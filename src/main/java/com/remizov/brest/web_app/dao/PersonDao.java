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

    public void save(Person person) {
        person.setId(++peopleCount);
        people.add(person);
    }

    public void update(int id, Person person) {
        Person person1 = getPersonByID(1);
        person1.setName(person.getName());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
