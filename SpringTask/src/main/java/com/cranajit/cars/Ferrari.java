package com.cranajit.cars;

import com.cranajit.interfaces.Car;
import com.cranajit.interfaces.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Ferrari implements Car {

    @Autowired
    @Qualifier("v6_engine")
    Engine engine;

    @Override
    public String getName() {
        return "CAR NAME: Ferrari | Engine TYPE: "+engine.getType();
    }
}
