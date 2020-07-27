package com.cranajit.engines;

import com.cranajit.interfaces.Engine;

public class V8 implements Engine {
    private String type;

    public V8() {
        type="WATER";
    }

    public V8(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return type+" COOLED V8 ENGINE";
    }
}
