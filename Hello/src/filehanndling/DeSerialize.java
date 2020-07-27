package filehanndling;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerialize {
    public static void main(String[] args) {
        try(FileInputStream fi = new FileInputStream("ron.dat")) {
            try(ObjectInputStream oi = new ObjectInputStream(fi)){
                Student s1 = (Student) oi.readObject();
                Student s2 = (Student) oi.readObject();
                System.out.println(s1+"***"+s2);
            }
        } catch(IOException e) {
            System.out.println(e.getMessage());
        } catch(ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
