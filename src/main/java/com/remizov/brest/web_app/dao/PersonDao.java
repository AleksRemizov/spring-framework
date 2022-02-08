package com.remizov.brest.web_app.dao;

import com.remizov.brest.web_app.model.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDao {
    private static int peopleCount;
    public List<Person> people;
    {
        people = new ArrayList<>();
        people.add(new Person(++peopleCount,"Tom"));
        people.add(new Person(++peopleCount,"Mike"));
        people.add(new Person(++peopleCount,"Nick"));
        people.add(new Person(++peopleCount,"Ann"));

    }

    public List<Person>getAllPerson(){
        return people;
    }

    public Person getPersonByID(int id){
     return people.stream().filter(person ->person.getId() == id).findAny().orElse(null);
    }

}
