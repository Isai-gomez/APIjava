package com.APIjava.apijava.PersonModel;

import java.util.ArrayList;

public interface PersonServiceInterface{
    // Save operation
    Person savePerson(Person Person);
 
    // Read operation
    ArrayList<Person> fetchPersonList();
 
    // Update operation
    Person updatePerson(Person Person, Integer PersonId);
 
    // Delete operation
    Boolean deletePersonById(Integer PersonId);
}
