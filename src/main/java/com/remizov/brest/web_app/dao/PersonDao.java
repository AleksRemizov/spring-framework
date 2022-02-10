package com.remizov.brest.web_app.dao;

import com.remizov.brest.web_app.model.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDao {
    private static int PEOPLE_COUNT;
    private static Connection connection;
    private static final String URL = "jdbc:postgresql://localhost:5432/first_db";
    private static final String USERNAME ="postgres";
    private static final String PASSWORD ="postgre";


    private static final String SQL_GET_ALL_PERSON="SELECT * FROM person";


    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Person> index()  {
        List<Person> people = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_GET_ALL_PERSON);

            while (resultSet.next()){
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));

                people.add(person);
                System.out.println(person);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return people;
    }

    public Person show(int id) {
        return null;
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);

    }

    public void update(int id, Person updatedPerson) {
        try {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO person VALUES(" + 1 + ",'" + updatedPerson.getName() +
                    "'," + updatedPerson.getAge() + ",'" + updatedPerson.getEmail() + "')";

            statement.executeUpdate(SQL);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void delete(int id) {

    }
}

