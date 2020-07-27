package com.annotations;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Science implements Teacher {
    @Override
    public void teach() {
        System.out.println("Science Teacher");
    }
}
