package com.remizov.springcourse;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestSpring {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );
        MusicPlayer musicPlayer =context.getBean("musicPlayer",MusicPlayer.class);

        System.out.println(musicPlayer.getName() + ".volume:" + musicPlayer.getVolume() );
         musicPlayer.playMusic(TypeMusic.ROCK);

        System.out.println(musicPlayer.getName() + ".volume:" + musicPlayer.getVolume() +".Playing :");
        musicPlayer.playMusic(TypeMusic.CLASSICAL);

        RetroMusic retroMusic1 = context.getBean("retroMusic",RetroMusic.class);
        RetroMusic retroMusic2 = context.getBean("retroMusic",RetroMusic.class);
        System.out.println(retroMusic1 == retroMusic2);
        context.close();
    }
}
