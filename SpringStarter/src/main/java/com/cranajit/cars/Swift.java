package com.cranajit.cars;

import com.cranajit.interfaces.Car;
import org.springframework.stereotype.Component;

@Component("swift")
public class Swift implements Car {

    @Override
    public String specs() {
        return "hatchback";
    }
}
