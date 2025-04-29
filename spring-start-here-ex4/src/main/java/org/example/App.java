package org.example;

import org.example.beans.Person;
import org.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(
                ProjectConfig.class
        );

        System.out.println("test");

        Person p = context.getBean(Person.class);
        System.out.println(p);

    }
}
