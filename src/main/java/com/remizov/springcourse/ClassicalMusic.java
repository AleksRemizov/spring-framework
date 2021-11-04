package com.remizov.springcourse;

import org.springframework.stereotype.Component;

@Component
public class ClassicalMusic implements Music{
    private ClassicalMusic(){}

    //only static!!!
     public static ClassicalMusic getClassicalMusic(){
        return new ClassicalMusic();
     }

    @Override
    public String getSong() {
        return "Antonio Vivaldi 'La primavera'";
    }
}
