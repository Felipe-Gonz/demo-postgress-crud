package com.lfg.demo_postgress_crud.dao;

import com.lfg.demo_postgress_crud.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDao extends JpaRepository<Person, Long> {

}
