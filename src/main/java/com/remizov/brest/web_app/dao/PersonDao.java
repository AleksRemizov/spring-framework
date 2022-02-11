package com.remizov.brest.web_app.dao;

import com.remizov.brest.web_app.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class PersonDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public PersonDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Person> index()  {
        return namedParameterJdbcTemplate.query("SELECT * FROM person",new PersonMapper());
    }
    public Person show(int id) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("id", id);
        return namedParameterJdbcTemplate.query("SELECT * FROM Person WHERE id= :id", sqlParameterSource,
                        new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    public void save(Person person) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("name", person.getName())
                .addValue("age", person.getAge())
                .addValue("email", person.getEmail());
        namedParameterJdbcTemplate.update("INSERT INTO person(id ,name , age , email) VALUES(1, :name, :age, :email)",sqlParameterSource);
    }

    public void update(int id, Person updatedPerson) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("name", updatedPerson.getName())
                .addValue("age", updatedPerson.getAge())
                .addValue("email", updatedPerson.getEmail());

         namedParameterJdbcTemplate.update("UPDATE person set name = :name, age = :age,email = :email WHERE id= :id", sqlParameterSource);
    }

    public void delete(int id) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("id", id);
        namedParameterJdbcTemplate.update("DELETE FROM person WHERE id= :id", sqlParameterSource);
    }
}

