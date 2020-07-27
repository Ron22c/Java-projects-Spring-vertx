package MultiThreading;

public class ThreadPractice {
    public static int count = 0;

    public static void main(String args[]) throws InterruptedException {
        Count2 c1 = new Count2(1);
        Count2 c2 = new Count2(2);

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<=1000;i++){
                    count++;
                }
                System.out.println("thread 1 over");
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<=1000;i++){
                    count++;
                }
                System.out.println("thread 1 over");
            }
        });

        t1.start();
        t2.start();

        Thread.sleep(1000);
        System.out.println(count);

//        long start = System.currentTimeMillis();
//        c1.start();
//        System.out.println("*******************");
//        c2.start();
//        long end = System.currentTimeMillis();
//        System.out.println("total time: "+(end-start));

//        Thread th = new Thread(c1);
//        Thread th2 = new Thread(c2);
//
//        th.start();
//        th2.start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(int i=0; i<10;i++) {
//                    System.out.println(i+"*** thread 4");
//                }
//            }
//        }).start();

    }
}

class Count2 implements Runnable {
    private int number;

    public Count2(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i=1; i<=10;i++) {
            System.out.println(i+ "***"+number);
        }
    }
}

class Count extends Thread{
    private int threadNumber;
    public Count(int no) {
        this.threadNumber = no;
    }

    public void run() {
        countMe();
    }

    public void countMe() {
        for(int i=0; i<=9; i++) {
            System.out.println("the value is "+i+" and the thread no is"+threadNumber);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
