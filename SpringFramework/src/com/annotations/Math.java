package com.annotations;

import org.springframework.stereotype.Component;

@Component
public class Math implements Teacher {
    @Override
    public void teach() {
        System.out.println("Math Teacher");
    }
}
