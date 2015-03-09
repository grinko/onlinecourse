package org.grinko.onlinecourse.rest.controller;

import org.grinko.onlinecourse.rest.DO.Person;
import org.grinko.onlinecourse.rest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by grinko on 8.3.15.
 */
@RestController
@RequestMapping("/persons")
public class PersonRESTController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Person> getAll() {
        return (List<Person>) personRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Person create(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@RequestBody Long id) {
        personRepository.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public Person update(@RequestBody Long id, @RequestBody Person person) {
        Person oldPerson = personRepository.findOne(id);
        oldPerson.setFirstName(person.getFirstName());
        oldPerson.setLastName(person.getLastName());
        oldPerson.setAge(person.getAge());
        return personRepository.save(oldPerson);
    }
}
