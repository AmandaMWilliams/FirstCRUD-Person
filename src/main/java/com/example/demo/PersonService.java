package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;

@Service
public class PersonService {
    private PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Person create(Person person){
        return repository.save(person);
    }

    public Person read(Long id){
        return repository.findById(id).get();
    }

    public Person update(Long id, Person newData){
        Person personInDatabase = read(id);
        personInDatabase.setFirstName(newData.getFirstName());
        personInDatabase.setLastName(newData.getLastName());
        return personInDatabase;
    }

    public Person delete(Long id){
        Person deletedPerson = read(id);
        repository.deleteById(id);
        return deletedPerson;

    }
}
