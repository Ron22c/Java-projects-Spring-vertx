package filehanndling;

import java.io.Serializable;

public class Student implements Serializable {
    public static final long serialVersionUID= -336570312517750424L;
    private String name;
    private int roll;

    public Student(String name, int roll) {
        this.name = name;
        this.roll = roll;
    }

    public String toString() {
        return "name: "+name+" roll: "+roll;
    }
}
