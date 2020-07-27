package com.cranajit.cars;

import com.cranajit.interfaces.Car;
import com.cranajit.interfaces.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BMW implements Car {

    @Autowired
    @Qualifier("v8_engine")
    Engine engine;

    @Override
    public String getName() {
        return "CAR NAME: BMW | Engine TYPE: "+engine.getType();
    }
}
