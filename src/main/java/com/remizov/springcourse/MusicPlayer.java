package com.remizov.springcourse;



import org.springframework.beans.factory.annotation.Value;


import java.util.List;
import java.util.Random;


public class MusicPlayer {
    @Value("${musicPlayer.name}")
    private String name;

    @Value("${musicPlayer.volume}")
    private int volume;

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    private List<String> playlist;


    public MusicPlayer(List<String> playlist) {
        this.playlist = playlist;
    }

    public void playMusic() {
        Random random = new Random();
        System.out.println("MusicPlayer" + getName() + " volume :"+getVolume());
        System.out.println("Play" + playlist.get(random.nextInt(playlist.size())));

    }
}
