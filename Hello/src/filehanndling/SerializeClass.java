package filehanndling;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeClass {
    public static void main(String[] args) {
        Student s1= new Student("Ranajit", 21);
        Student s2= new Student("Ron", 22);

        try(FileOutputStream fo = new FileOutputStream("ron.dat")){
            try(ObjectOutputStream oo = new ObjectOutputStream(fo)){
                oo.writeObject(s1);
                oo.writeObject(s2);
                System.out.println("Success");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
