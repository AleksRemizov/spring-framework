package com.remizov.springcourse;

import org.springframework.stereotype.Component;

@Component
public class RetroMusic implements Music{
    @Override
    public String getSong() {
        return "Леонид Утёсов 'Раскинулось море широко'";
    }
}
