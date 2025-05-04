package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class UserDaoImp implements UserDao {

   private static final String HQL_GET_USER_BY_CAR =
           "FROM User WHERE car.model = :model AND car.series = :series";

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void addUser(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public List<User> listAllUsers() {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User getUserByCarModelAndSeries(String model, int series) {
      return sessionFactory.getCurrentSession()
              .createQuery(HQL_GET_USER_BY_CAR, User.class)
              .setParameter("model", model)
              .setParameter("series", series)
              .uniqueResult();
   }

}
