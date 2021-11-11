package com.remizov.springcourse;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClassicalMusic implements Music{
    List<String> songs = new ArrayList<>();
    {
        songs.add("Antonio Vivaldi 'La primavera'");
        songs.add("Ludwig van Beethoven" +
                " Symphony №6 'Pastoral', Op. 68");
        songs.add("Чайковский" +
                " Чай. Китайский танец (Щелкунчик)");
    }

    @Override
    public List<String> getSong() {
        return songs;
    }
}
