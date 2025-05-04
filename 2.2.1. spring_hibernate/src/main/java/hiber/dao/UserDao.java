package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   void addUser(User user);
   List<User> listAllUsers();
   User getUserByCarModelAndSeries(String model, int series);
}
