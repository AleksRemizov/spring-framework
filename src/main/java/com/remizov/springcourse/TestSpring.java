package com.remizov.springcourse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestSpring {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );
        List<Music>musicList = new ArrayList<>();
        Music musicRock =context.getBean("hardRock",Music.class);
        musicList.add(musicRock);
        Music musicRetro =context.getBean("retroMusic",Music.class);
        musicList.add(musicRetro);
        Music musicClassical =context.getBean("classicalMusic",Music.class);
        musicList.add(musicClassical);

        MusicPlayer musicPlayer = new MusicPlayer(musicList);
        musicPlayer.playMusic();


        context.close();
    }
}
