package com.lfg.demo_postgress_crud.services;

import com.lfg.demo_postgress_crud.entity.Person;

import java.util.List;

public interface PersonService {

    public List<Person> findAll();
    public Person save(Person person);
    public Person findById(Long id);
    public void delete(Person person);

}
