package com.remizov.springcourse;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RetroMusic implements Music{
    List<String>songs = new ArrayList<>();
    {
        songs.add("Леонид Утёсов 'Раскинулось море широко'");
    }
    @Override
    public List<String> getSong() {
        return songs;
    }
}
