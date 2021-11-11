package com.remizov.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MusicPlayer {
    private Music music1;
    private Music music2;
    @Autowired
    public MusicPlayer(@Qualifier("rockMusic") Music music1, @Qualifier("classicalMusic") Music music2) {
        this.music1 = music1;
        this.music2 = music2;
    }

    public void playMusic(TypeMusic typeMusic){
        Random random = new Random();
           if (typeMusic == TypeMusic.CLASSICAL){
               System.out.println(music2.getSong().get(random.nextInt(music2.getSong().size())));
           }else{
               System.out.println(music1.getSong().get(random.nextInt(music1.getSong().size())));
           }
        }
}
