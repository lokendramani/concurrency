package org.example.deadlock;

public class DeadlockDemo {

    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        Thread rootAtrains = new Thread(new TrainA(intersection));
        Thread rootBtrains = new Thread(new TrainB(intersection));

        rootAtrains.start();
        rootBtrains.start();
    }
}
