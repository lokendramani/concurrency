package org.example.deadlock;

import java.util.Random;

public class TrainB implements  Runnable
    {
        Intersection intersection;
       Random random = new Random();
        TrainB(Intersection intersection){
            this.intersection = intersection;
        }



    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(random.nextInt(5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            intersection.takeRoadB();
        }
        }
    }


