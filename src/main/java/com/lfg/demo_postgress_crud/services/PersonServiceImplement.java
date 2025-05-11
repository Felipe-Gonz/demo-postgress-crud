package com.lfg.demo_postgress_crud.services;

import com.lfg.demo_postgress_crud.dao.PersonDao;
import com.lfg.demo_postgress_crud.entity.Person;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PersonServiceImplement implements PersonService{

    @Autowired
    private PersonDao personDao;

    @Override
    @Transactional
    public List<Person> findAll() {
        return (List<Person>) personDao.findAll();
    }

    @Override
    @Transactional
    public Person save(Person person) {
        return personDao.save(person);
    }

    @Override
    @Transactional
    public Person findById(Long id) {
        return personDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Person person) {
        personDao.delete(person);
    }
}
