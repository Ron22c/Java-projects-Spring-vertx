package filehanndling;

import java.io.*;

public class FHwithThread {
    public static void main(String[] args) throws InterruptedException {
        File f1 = new File("src/ron.txt");
        File f2 = new File("ron.dat");
        Student s1 = new Student("Ron",123);
        Student s2 = new Student("Ranajit",123);
        ReadWrite rw = new ReadWrite();

        Thread t1 = new Thread(()->{
            synchronized (f1){try(BufferedWriter br = new BufferedWriter(new FileWriter(f1))) {
                for(int i=0;i<10;i++){
                    br.write("hello "+i);
                    br.newLine();
                    System.out.println("line added: "+i);
                }
            } catch(FileNotFoundException e ){
                System.out.println("EXp: "+e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }}
        });

        Thread t2 = new Thread(()->{
            synchronized (f1){
                try(BufferedReader read = new BufferedReader(new FileReader(f1))) {
                String line;
                while((line = read.readLine()) != null) {
                    System.out.println(line);
                }
            } catch(FileNotFoundException e ){
                System.out.println("EXp: "+e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }}
        });

        Thread t3 = new Thread(()->{
            rw.readObject(f2);
        });

        Thread t4 = new Thread(()->{
            rw.writeObject(f2, s1, s2);
        });

//        t1.start();
//        t2.start();
        t3.start();
        t4.start();


//        t1.join();
//        t2.join();
        t3.join();
        t4.join();

        System.out.println("In main thread");
    }
}

class ReadWrite {
    public void writeObject(File f, Student one, Student two) {
        try(FileOutputStream fo = new FileOutputStream(f)){
            try(ObjectOutputStream oo = new ObjectOutputStream(fo)){
                oo.writeObject(one);
                oo.writeObject(two);
                synchronized (this) {
                    System.out.println("calling nortify");
                    notify();
                }
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void readObject(File f) {
        try(FileInputStream fi = new FileInputStream(f)) {
            try(ObjectInputStream oi = new ObjectInputStream(fi)) {
                synchronized (this){
                    System.out.println("read object");
                    try{
                        if(oi.available()<=0){
                            System.out.println("inside lock");
                            wait();
                        }
                        Student s1 = (Student) oi.readObject();
                        System.out.println(s1.toString());
                        Student s2 = (Student) oi.readObject();
                        System.out.println(s2.toString());
                    } catch (ClassNotFoundException | InterruptedException | IOException e){
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
