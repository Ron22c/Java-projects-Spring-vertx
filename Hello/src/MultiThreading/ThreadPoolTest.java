package MultiThreading;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);


        SecondaryClass th1 = new SecondaryClass("th1");
        SecondaryClass th14 = new SecondaryClass("th14");
        SecondaryClass th2 = new SecondaryClass("th2");
        SecondaryClass th3 = new SecondaryClass("th3");
        SecondaryClass th4 = new SecondaryClass("th4");
        SecondaryClass th5 = new SecondaryClass("th5");
        SecondaryClass th6 = new SecondaryClass("th6");
        SecondaryClass th7 = new SecondaryClass("th7");
        SecondaryClass th8 = new SecondaryClass("th8");
        SecondaryClass th9 = new SecondaryClass("th9");
        SecondaryClass th10 = new SecondaryClass("th10");
        SecondaryClass th11 = new SecondaryClass("th11");
        SecondaryClass th12 = new SecondaryClass("th12");
        SecondaryClass th13 = new SecondaryClass("th13");

        service.execute(th1);
        service.execute(th2);
        service.execute(th3);
        service.execute(th4);
        service.execute(th5);
        service.execute(th6);
        service.execute(th7);
        service.execute(th8);
        service.execute(th9);
        service.execute(th10);
        service.execute(th11);

        service.shutdown();

    }
}

class SecondaryClass extends Thread {

    private String name;
    private CountDownLatch latch;

    public SecondaryClass(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Staring of thread: "+name+Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        latch.countDown();
        System.out.println("ending of thread: "+name+Thread.currentThread().getName());
    }
}