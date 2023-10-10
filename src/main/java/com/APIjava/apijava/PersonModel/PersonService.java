package com.APIjava.apijava.PersonModel;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonService implements PersonServiceInterface {
    private final PersonRepository personRepo;

    @Override
    public Person savePerson(Person person) {
        return personRepo.save(person);
    }

    public ArrayList<Person> fetchPersonList() {
        return (ArrayList<Person>) personRepo.findAll();
    }

    @Override
    public Person updatePerson(Person person, Integer personId) {
        Person depDB = personRepo.findById(personId).get();

        if (Objects.nonNull(person.getName())
                && !"".equalsIgnoreCase(
                        person.getName())) {
            depDB.setName(
                    person.getName());
        }

        if (Objects.nonNull(
                person.getLastName())
                && !"".equalsIgnoreCase(
                        person.getLastName())) {
            depDB.setLastName(
                    person.getLastName());
        }

        if (Objects.nonNull(person.getEmail())
                && !"".equalsIgnoreCase(
                        person.getEmail())) {
            depDB.setEmail(
                    person.getEmail());
        }

        return personRepo.save(depDB);
    }

    @Override
    public Boolean deletePersonById(Integer PersonId) {
        // TODO Auto-generated method stub
        Boolean state = false;
        if(personRepo.findById(PersonId).isEmpty()){
            return state;
        }else{

            personRepo.findById(PersonId);
            personRepo.deleteById(PersonId);
            return state=true;
        }
    }

}
