package com.remizov.springcourse.config;

import com.remizov.springcourse.MusicPlayer;
import com.remizov.springcourse.music.ClassicalMusic;
import com.remizov.springcourse.music.RetroMusic;
import com.remizov.springcourse.music.RockMusic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {
    @Bean
    public ClassicalMusic classicalMusic(){
        return new ClassicalMusic();
    }
    @Bean
    public RockMusic rockMusic(){
        return new RockMusic();
    }
    @Bean
    public RetroMusic retroMusic(){
        return new RetroMusic();
    }
    public List<String> createPlaylist(){
        return Stream.
                of(classicalMusic().getSong(),retroMusic().getSong(),retroMusic().getSong()).
                flatMap(Collection::stream).
                collect(Collectors.toList());

    }
    @Bean
    public MusicPlayer musicPlayer(){
        return new MusicPlayer(createPlaylist());
    }
}
