package MultiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {
    public static void main(String[] args) throws InterruptedException {
        String obj1 = "one";
        String obj2 = "two";

        LockWithReentrant.testLock();

        Thread th1 = new Thread(new Runnable() {
            public void run() {
                synchronized (obj1) {
                    System.out.println("thread one with obj 1");
                    synchronized(obj2) {
                        System.out.println("thread one with obj 2");
                    }
                }
            }
        });

        Thread th2 = new Thread(new Runnable() {
            public void run() {
                synchronized (obj1) {
                    System.out.println("thread two with obj 1");
                    synchronized(obj2) {
                        System.out.println("thread two with obj 2");
                    }
                }
            }
        });

        th1.start();
        th2.start();

        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("inside main method");
    }
}

class LockWithReentrant {
    public static void testLock() throws InterruptedException {
        Lock l1 = new ReentrantLock();
        Lock l2 = new ReentrantLock();

        Thread th1 = new Thread(new Runnable(){
            public void run() {
                boolean flagl1 = false;
                boolean flagl2 = false;
                boolean l1Done = false;
                boolean l2Done = false;

                while(true) {
                    try{
                        if(!l1Done) {
                            flagl1 = l1.tryLock();
                        }
                        if(!l2Done) {
                            flagl2 = l2.tryLock();
                        }
                    } finally {
                        if(flagl1) {
                            System.out.println("thread 1 lock 1");
                            l1.unlock();
                            l1Done=true;
                        }
                        if(flagl2) {
                            System.out.println("thread 1 lock 2");
                            l2.unlock();
                            l2Done=true;
                        }
                        if(flagl1 && flagl2) {
                            break;
                        }
                    }
                }
            }
        });

        Thread th2 = new Thread(new Runnable(){
            public void run() {
                boolean flagl1 = false;
                boolean flagl2 = false;
                boolean l1Done = false;
                boolean l2Done = false;

                while(true) {
                    try{
                        if(!l1Done) {
                            flagl1 = l1.tryLock();
                        }
                        if(!l2Done) {
                            flagl2 = l2.tryLock();
                        }
                    } finally {
                        if(flagl1) {
                            System.out.println("thread 2 lock 1");
                            l1.unlock();
                            l1Done=true;
                        }
                        if(flagl2) {
                            System.out.println("thread 2 lock 2");
                            l2.unlock();
                            l2Done=true;
                        }
                        if(flagl1 && flagl2) {
                            break;
                        }
                    }
                }
            }
        });

        th1.start();
        th2.start();

        th1.join();
        th2.join();
        System.out.println("inside main");
    }
}
