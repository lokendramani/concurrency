package org.example.singleton;

public class SingletonDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println(Singleton.getInstance());
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Singleton.getInstance());
            }
        });
        t1.start();
        t2.start();

    }
}
