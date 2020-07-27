package generics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenericsClass {
    public static void main(String args[]) {
        List<Vehicle> l = new ArrayList<>();
        l.add(new Vehicle(12));
        l.add(new Vehicle(13));
        l.add(new Vehicle(14));
        l.add(new Vehicle(15));
        l.add(new Car(16, "a12"));
        Display(l);

        Set<Integer>  set = new HashSet<>();
        for(int i=0; i<20;i++) {
            set.add(i);
        }
    }

    public static void Display(List<? super Car> list) {
        for(Object v:list) {
           System.out.println(v);
        }
    }
}

class Vehicle {
    private int data;

    public Vehicle(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "data=" + data +
                '}';
    }

    public void getInfo() {
        System.out.println(getData());
    }
}

class Car extends Vehicle {
    private String number;

    public Car(int data, String number) {
        super(data);
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Car{" +
                "number='" + number + '\'' +
                '}';
    }

    public void getInfo() {
        System.out.println(getNumber());
    }
}