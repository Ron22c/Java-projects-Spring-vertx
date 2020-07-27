package com.cranajit;

public class Airtel implements Sim {
    public Airtel() {
        System.out.println("This is airtel");
    }
    @Override
    public void calling() {
        System.out.println("Calling from airtel");
    }

    @Override
    public void data() {
        System.out.println("Browsing from airtel");
    }
}
