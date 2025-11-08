package T09_Threads;

import java.util.concurrent.atomic.AtomicInteger;

public class T09_00_RaceCondition {

    public static void main(String[] args) throws InterruptedException {
        Thread th1 = new Thread(new MyThread());
        Thread th2 = new Thread(new MyThread());

        th1.start();
        th2.start();

        th1.join();
        th2.join();

//        System.out.println(Data.n);
        System.out.println(Data.m);
    }
}

class Data {
//    static public int n = 0;
    static public AtomicInteger m = new AtomicInteger(0);
}

class MyThread implements Runnable {

    public static void addOne() {
//        Data.n = Data.n + 1;
        Data.m.incrementAndGet();
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            addOne();
        }
    }
}