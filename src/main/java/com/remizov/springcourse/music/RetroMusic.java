package com.remizov.springcourse.music;

import com.remizov.springcourse.music.Music;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


public class RetroMusic implements Music {
    List<String>songs = new ArrayList<>();

    {
        songs.add("Леонид Утёсов 'Раскинулось море широко'");
    }
    @Override
    public List<String> getSong() {
        return songs;
    }
}
