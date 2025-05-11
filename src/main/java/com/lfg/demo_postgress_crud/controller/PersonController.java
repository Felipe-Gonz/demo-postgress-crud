package com.lfg.demo_postgress_crud.controller;

import com.lfg.demo_postgress_crud.entity.Person;
import com.lfg.demo_postgress_crud.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/persons")
    public ResponseEntity<Object> get(){
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            List<Person> list = personService.findAll();
            return new ResponseEntity<Object>(list, HttpStatus.OK);
        }
        catch (Exception e){
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/persons/{id}/")
    public ResponseEntity<Object> getById(@PathVariable Long id){
        try{
            Person data = personService.findById(id);
            return new ResponseEntity<Object>(data, HttpStatus.OK);
        }
        catch (Exception e){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping(value = "/persons")
    public ResponseEntity<Object> create(@RequestBody Person person){
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            Person res = personService.save(person);
            return new ResponseEntity<Object>(res, HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/persons/{id}")
    public ResponseEntity<Object> update(@RequestBody Person person, @PathVariable Long id){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Person currentPerson = personService.findById(id);

            currentPerson.setName(person.getName());
            currentPerson.setAddresss(person.getAddresss());
            currentPerson.setPhone(person.getPhone());

            Person res = personService.save(person);

            return new ResponseEntity<Object>(res, HttpStatus.OK);
        }
        catch (Exception e){
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/persons/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Person currentPerson = personService.findById(id);
            personService.delete(currentPerson);
            map.put("delete", true);
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }
        catch (Exception e){
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
