package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> listAllUsers();
    User getUserByCarModelAndSeries(String model, int series);
}
