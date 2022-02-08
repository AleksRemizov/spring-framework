package com.remizov.brest.web_app.controllers;

import com.remizov.brest.web_app.dao.PersonDao;
import com.remizov.brest.web_app.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDao personDao;

    public PeopleController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping()
    public String getAllPerson(Model model){
        model.addAttribute("people",personDao.getAllPerson());
        return "people/perform";
    }

    @GetMapping("/{id}")
    public String getPersonByID(@PathVariable("id") int id,Model model){
        model.addAttribute("person",personDao.getPersonByID(id));
        return "people/personalPage";
    }
    @GetMapping("/new")
    public String personPage(Model model){
        model.addAttribute("person",new Person());
        return "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person")Person person){
        personDao.save(person);
        return "redirect:/people";

    }
}

