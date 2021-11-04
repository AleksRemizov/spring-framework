package com.remizov.springcourse;

public interface Music {
    String getSong();
    default void doMyInit(){
        System.out.println("Init my initialization");
    }
    default void doMyDestroy(){
        System.out.println("Doing my destruction");
    }
}
