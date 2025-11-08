package T09_Threads;

public class T09_00_Example {

    public static void main(String[] args) throws InterruptedException {
        Thread1 th1 = new Thread1();
        Thread2 th2 = new Thread2();

        th1.setDaemon(true);

        System.out.println("Start!");
        th1.start();
        th2.start();

//        th1.join();
        th2.join();
        System.out.println("End!");
    }
}


class Thread1 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(i);
            Thread.yield();
        }
    }
}

class Thread2 extends Thread {

    @Override
    public void run() {
        for (int i = -1; i > -25; i--) {
            System.out.println(i);
            Thread.yield();
        }
    }
}