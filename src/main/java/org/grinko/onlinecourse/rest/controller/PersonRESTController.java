package org.grinko.onlinecourse.rest.controller;

import com.googlecode.jcsv.writer.CSVWriter;
import com.googlecode.jcsv.writer.internal.CSVWriterBuilder;
import org.grinko.onlinecourse.rest.DO.Person;
import org.grinko.onlinecourse.rest.controller.utils.PersonEntryConverter;
import org.grinko.onlinecourse.rest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 * Created by grinko on 8.3.15.
 */
@RestController
@RequestMapping("/persons")
public class PersonRESTController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Person> getAll() {
        return (List<Person>) personRepository.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Person create(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@RequestBody Long id) {
        personRepository.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Person update(@RequestBody Long id, @RequestBody Person person) {
        Person oldPerson = personRepository.findOne(id);
        oldPerson.setFirstName(person.getFirstName());
        oldPerson.setLastName(person.getLastName());
        oldPerson.setAge(person.getAge());
        return personRepository.save(oldPerson);
    }

    @RequestMapping(value = "/csv", method = RequestMethod.GET)
    public void getCsv(HttpServletResponse response) {
        //TODO rid of hardcode
        String csvFileName = "persons.csv";
        response.setContentType("text/csv");
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", csvFileName);
        response.setCharacterEncoding("UTF-8");
        response.setHeader(headerKey, headerValue);

        List<Person> persons = (List<Person>) personRepository.findAll();
        Writer out;
        try {
            out = response.getWriter();
            CSVWriter<Person> csvWriter = new CSVWriterBuilder<Person>(out).entryConverter(new PersonEntryConverter()).build();
            csvWriter.writeAll(persons);

            csvWriter.close();
        } catch (IOException e) {
            //TODO replace with logger
            e.printStackTrace();
        }
    }

    //TODO 404
    
}