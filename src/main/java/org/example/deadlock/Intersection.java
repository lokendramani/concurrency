package org.example.deadlock;

public class Intersection {
private Object roadA = new Object();
private  Object roadB = new Object();

    public void takeRoadA(){
        synchronized (roadA){
            System.out.println(Thread.currentThread().getName()+" took lock on RoadA");
            synchronized(roadB){
                System.out.println(Thread.currentThread().getName()+" took lock on RoadB, now crossing RoadA");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
    public void takeRoadB(){
        synchronized (roadB){
            System.out.println(Thread.currentThread().getName()+" took lock on RoadB");
            synchronized(roadA){
                System.out.println(Thread.currentThread().getName()+" took lock on RoadA, now crossing RoadB");
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }


}
