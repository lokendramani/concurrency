package org.example.hackerPolice;

public class PoliceThread extends Thread{

    public void run(){
        for (int i = 10; i > 0; i--) {
            try {
                Thread.sleep(1000);
                System.out.println("Tick Tick-"+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Game over for you Hackers!!!");
        System.exit(0);
    }
}
