package com.APIjava.apijava.PersonModel;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
// @RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {
    public final PersonService personService;

    @PostMapping(value = "/person")
    public Person createPerson(@RequestBody Person person) {
        personService.savePerson(person);
        return person;
    }

    @GetMapping(value = "/person")
    public ArrayList<Person> fetchPersonList() {
        return personService.fetchPersonList();
    }

    @PutMapping( value = "/person/{id}")
    public Person UpdatePerson(@RequestBody Person person, @PathVariable("id") Integer personId) {
        return personService.updatePerson(person, personId);
    }

    @DeleteMapping(value = "/person/{id}")
    public String deletePersonById(@PathVariable("id") Integer personId) {
        if (personService.deletePersonById(personId)) {
            return "Deleted person winth id" + " " + personId;
        }
        ;
        return "No se encontro el id" + " " + personId;

    }
}