package org.example;


import org.example.config.ProjectConfig;
import org.example.data.Parrot;
import org.example.data.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext
                (ProjectConfig.class);

        System.out.println("test");

        Person person = context.getBean(Person.class);
        Parrot parrot = context.getBean(Parrot.class);
        Parrot parrot1 = context.getBean("parrotKoko", Parrot.class);

        System.out.println(parrot1);
        System.out.println(parrot);
        System.out.println(person + " " + person.getParrot());
    }
}
