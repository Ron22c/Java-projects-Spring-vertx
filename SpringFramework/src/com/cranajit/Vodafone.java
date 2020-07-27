package com.cranajit;

public class Vodafone implements Sim {
    @Override
    public void calling() {
        System.out.println("Calling from Vodafone");
    }

    @Override
    public void data() {
        System.out.println("Browsing from Vodafone");
    }
}
