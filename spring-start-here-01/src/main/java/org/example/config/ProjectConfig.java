package org.example.config;

import org.example.data.Parrot;
import org.example.data.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {

    @Bean
    public Parrot parrotKoko() {
        Parrot parrot = new Parrot();
        parrot.setName("Koko");
        return parrot;
    }

    //    spring will look in the context for a bean type Parrot to inject
    @Bean
    public Person person(@Qualifier("parrotKoko") Parrot parrot) {
        Person person = new Person();
        person.setName("Ela");
        person.setParrot(parrot);
        return person;
    }

    @Bean
    @Primary
    public Parrot parrot2() {
        Parrot parrot = new Parrot();
        parrot.setName("DEFAULT_PARROT");
        return parrot;
    }

//    == wiring ==
//    @Bean
//    public Person person() {
//        Person person = new Person();
//        person.setName("Ela");
//        person.setParrot(parrot());
//        return person;
//    }

}
