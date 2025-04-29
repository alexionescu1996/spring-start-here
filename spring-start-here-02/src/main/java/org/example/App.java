package org.example;

import org.example.config.ProjectConfig;
import org.example.services.*;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;


public class App {
    public static void main(String[] args) {

        var context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);

        var s1 = context.getBean(CommentService.class);
        var s2 = context.getBean(UserService.class);
//       Bean default scope is Singleton
        System.out.println(s1.getCommentRepository() == s2.getCommentRepository());


//        Bean Scope Prototype will provide different instances of the same object
        var bookService1 = context.getBean(BookService.class);
        var bookService2 = context.getBean(BookService.class);
        System.out.println(bookService1 == bookService2);


//        Component Scope Prototype will provide different instances of the same object
        var bikeService = context.getBean(BikeService.class);
        var carService = context.getBean(CarService.class);
        System.out.println(bikeService.getWheelRepository() == carService.getWheelRepository());
    }
}
