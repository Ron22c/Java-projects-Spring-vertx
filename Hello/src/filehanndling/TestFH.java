package filehanndling;

import java.io.*;

public class TestFH {
        public static void main(String[] args) throws InterruptedException {
            File f1 = new File("src/ron.txt");
            File f2 = new File("ron.dat");
            Student s1 = new Student("Ron",123);
            Student s2 = new Student("Ranajit",123);
            Object lock = "lock";

            Thread t1 = new Thread(()->{
                synchronized (lock){try(BufferedWriter br = new BufferedWriter(new FileWriter(f1))) {
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

            Thread t2 = new Thread(()-> {
                synchronized (lock){
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

                    try (FileOutputStream fo = new FileOutputStream(f2)) {
                        System.out.println("inside producer");
                        try (ObjectOutputStream oo = new ObjectOutputStream(fo)) {
                            oo.writeObject(s1);
                            oo.writeObject(s2);
                            System.out.println("Success");
                            synchronized (lock) {
                                System.out.println("nortify");
                                lock.notify();
                            }
                    } catch (FileNotFoundException e) {
                        System.out.println("EXp: " + e.getMessage());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            });

            Thread t4 = new Thread(()->{
                    try (FileInputStream fi = new FileInputStream(f2)) {
                        System.out.println("inside consumer");
                        try (ObjectInputStream oi = new ObjectInputStream(fi)) {
                            synchronized (lock) {
                                if(oi.available()<=0) {
                                    System.out.println("wait");
                                    lock.wait();
                                }
                                Student st1 = (Student) oi.readObject();
                                Student st2 = (Student) oi.readObject();
                                System.out.println(st1.toString());
                                System.out.println(st2.toString());
                            }
                    } catch (FileNotFoundException e) {
                        System.out.println("EXp: " + e.getMessage());
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            });

//        t1.start();
//        t2.start();
            t3.start();
            t4.start();


//        t1.join();
//        t2.join();
            t3.join();

            synchronized (lock){
                System.out.println("main nortify");

                lock.notify();
            }
            t4.join();
            System.out.println("In main thread");
        }
    }
