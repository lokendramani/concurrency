package org.example.deadlock;

import java.util.Random;

public class TrainA implements Runnable{
    Intersection intersection;
    Random random = new Random();
    TrainA(Intersection intersection){
        this.intersection=intersection;

    }
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(random.nextInt(5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            intersection.takeRoadA();
        }

    }
}
