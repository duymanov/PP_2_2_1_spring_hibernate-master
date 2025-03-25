package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

     UserService userService = context.getBean(UserService.class);

      User user = new User("Alex","Shendler","klqwedfmwklq@mail.ru");
      User user2 = new User("ewgweg","gewegwwge","wegwegq@mail.ru");
      User user3 = new User("xcbxcb","xcbxcbxcb","gweq@mail.ru");
      Car car = new Car("BMW",320);
      Car car2 = new Car("Mercedes",2);
      Car car3 = new Car("MiniCooper",12308921);
      user.setCar(car3);
      user2.setCar(car2);
      user3.setCar(car);

      userService.add(user);
      userService.add(user2);
      userService.add(user3);


      userService.getUserByCar("BMW",320);
      userService.getUserByCar("Mercedes",2);
      userService.getUserByCar("MiniCooper", 12308921);


//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }

      context.close();
   }
}
