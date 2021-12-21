package com.remizov.springcourse.music;

import com.remizov.springcourse.music.Music;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


public class RockMusic implements Music {

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
