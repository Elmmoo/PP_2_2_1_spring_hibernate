package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   void addUser(User user);
   List<User> findAllUsers(); // Изменение
   User getUserByCarModelAndSeries(String model, int series);
}
