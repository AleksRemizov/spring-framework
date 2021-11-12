package com.remizov.springcourse;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("rockMusic")
public class RockMusic implements Music{

    List<String> songs = new ArrayList<>();
    {
        songs.add("Till Lindemann 'Любимый город' ");
        songs.add("DREZDEN" + " ЭДЕЛЬВЕЙС");
        songs.add("Земфира" + " пальто");

    }


    @Override
    public List<String> getSong() {
        return songs;
    }
}
