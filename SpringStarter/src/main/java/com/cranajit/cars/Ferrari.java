package com.cranajit.cars;

import com.cranajit.interfaces.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ferrari")
public class Ferrari implements Car {

    Engine engine;

//    public Ferrari (Engine engine) {
//        engine.type = "new type";
//        this.engine = engine;
//    }

    public void setEngine(Engine engine) {
        engine.type = "set type";
        this.engine = engine;
    }

    @Override
    public String specs() {
        return "sports car "+engine.getType();
    }
}