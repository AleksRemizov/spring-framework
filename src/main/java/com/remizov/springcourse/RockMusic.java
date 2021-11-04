package com.remizov.springcourse;

import org.springframework.stereotype.Component;

@Component("hardRock")
public class RockMusic implements Music{
    @Override
    public String getSong() {
        return "Till Lindemann 'Любимый город' ";
    }
}
