package lambdafunctions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.function.IntPredicate;

interface First {
    public void print();
}

public class Lambda {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(12, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(()-> System.out.println("thread"));
            }
        });

        service.execute(() -> System.out.println("started service"));
        ThreadCheck tc = new ThreadCheck();

        First f = () -> System.out.println("hello");
        f.print();

        Thread th = new Thread(()-> {
            System.out.println("inside the thread");

        });
        tc.start();
        th.start();

        new Thread(()->{
            List<Integer> li = new ArrayList<>();
            li.add(1);
            li.add(2);
            li.add(3);
            li.add(4);
            li.add(15);
            synchronized (tc){
                tc.notify();
            }

            li.forEach((i) -> System.out.println(i));
        }).start();

        th.join();
        System.out.println("Main thread");

        IntPredicate idEven = (value) -> (value%2 == 0);

        System.out.println(idEven.test(12));
        service.shutdown();
    }

}

class ThreadCheck extends Thread {
    public void run() {
        System.out.println("inside run");
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("inside run nortify");
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}