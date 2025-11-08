package T09_Threads;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class A09_03 {

    public static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        double T1 = 2.0;
        double T2 = 4.0;
        double T3 = 0.0;
        double T4 = 15.0;
        final int n = 10;

        Semaphore lock = new Semaphore(2,true);

        Thread[] trains = new Thread[n];

        Log.print("Start");
        for (int i = 0; i < n; i++) {
            long arriveTime = (long) ((Math.random() * (T4 - T3) + T3) * 1000);
            long transitTime = (long) ((Math.random() * (T2 - T1) + T1) * 1000);

            int j = i;
            trains[i] = new Thread(() -> train(j, arriveTime, transitTime, lock));
            trains[i].start();
        }

        for (int i = 0; i < n; i++) {
            trains[i].join();
        }
        System.out.println(count);
        Log.print("End");
    }

    public static void train(int i, long arriveTime, long transitTime, Semaphore lock) {
        Thread.currentThread().setName("Train " + i);
        try {
            Thread.sleep(arriveTime);
            Log.print("has arrived");
            if (!lock.tryAcquire()) {
                count.incrementAndGet();
                lock.acquire();
            }
            Log.print("starts passing");
            Thread.sleep(transitTime);
            lock.release();
            Log.print("is passed");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}