package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class PersonConfig {
    @Autowired
    private PersonRepository repository;

    @PostConstruct
    public void setup(){
        Person person = new Person();
        person.setFirstName("Amanda");
        person.setLastName("Williams");
        repository.save(person);
    }
}
