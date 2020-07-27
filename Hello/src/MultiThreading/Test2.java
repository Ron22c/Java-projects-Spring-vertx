package MultiThreading;

public class Test2 {
    public volatile static int flag = 0;
    public static void main(String args[]) {
        Braces b = new Braces();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(int i=0; i<50;i++) {
//                    Braces.generation("one");
//                }
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(int i=0; i<50;i++) {
//                    Braces.generation("two");
//                }
//            }
//        }).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
//                    if(flag==0) {
//                        System.out.println("running");
//                    } else {
//                        break;
//                    }
//                }
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                flag=1;
//                System.out.println("over");
//            }
//        }).start();
        Bank bank = new Bank();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    bank.withdraw(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.setName("Thread One");
        System.out.println("t1 "+t1.getPriority());
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bank.deposit(20000);
            }
        });
        t2.setName("Thread two");
        System.out.println("t2 "+t2.getPriority());
        t2.start();
    }
}

class Bank {
    private int balance = 0;
    public void withdraw(int amount) throws InterruptedException {
        System.out.println("requesting for money");
        synchronized (this){
            if(balance<=0) {
            System.out.println(balance);
            wait();
        }}
        balance = balance-amount;
        System.out.println("withdrawl successful ! balance is" + balance);
    }

    public void deposit(int amount) {
        balance = balance+amount;
        System.out.println("money added successful");
        synchronized (this) {
            notify();
        }
    }
}

class Braces {
    private Object lock = "lock";

    public void generate() {
        for(int i=0; i<10;i++) {

            synchronized (lock) {
                if(i<5) {
                    System.out.print("[");
                } else {
                    System.out.print("]");
                }
            }

        }
        System.out.println();
    }

    synchronized public static void generation(String thread) {
        for(int i=0; i<10;i++) {
            if(i<5) {
                System.out.print("[");
            } else {
                System.out.print("]");
            }
        }
        System.out.println("thread name is: "+thread);
    }
}