package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("Tesla Model S", 2022);
      Car car2 = new Car("Audi A6", 2021);
      Car car3 = new Car("BMW X5", 2023);
      Car car4 = new Car("Toyota Camry", 2020);

      User user1 = new User("Ivan", "Petrov", "ivan@mail.ru");
      user1.setCar(car1);

      User user2 = new User("Anna", "Smirnova", "anna@yandex.ru");
      user2.setCar(car2);

      User user3 = new User("Sergey", "Ivanov", "sergey@gmail.com");
      user3.setCar(car3);

      User user4 = new User("Olga", "Sidorova", "olga@mail.ru");
      user4.setCar(car4);

      userService.addUser(user1);
      userService.addUser(user2);
      userService.addUser(user3);
      userService.addUser(user4);

      System.out.println("==== All Users ====");
      List<User> users = userService.listAllUsers();
      for (User user : users) {
         System.out.printf(
                 "User: %s %s | Car: %s (Series: %d)%n",
                 user.getFirstName(),
                 user.getLastName(),
                 user.getCar().getModel(),
                 user.getCar().getSeries()
         );
      }

      System.out.println("\n==== User Search ====");
      String targetModel = "BMW X5";
      int targetSeries = 2023;

      User foundUser = userService.getUserByCarModelAndSeries(targetModel, targetSeries);
      System.out.printf(
              "Found owner of %s (%d): %s %s%n",
              targetModel,
              targetSeries,
              foundUser.getFirstName(),
              foundUser.getLastName()
      );

      context.close();
   }
}
