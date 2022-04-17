package org.example.oddeven;

public class PrintEvenThread implements Runnable{
    OddEvenPrint oddEvenPrint;
    PrintEvenThread(OddEvenPrint oddEvenPrint){
        this.oddEvenPrint = oddEvenPrint;
    }

    @Override
    public void run() {
        try {
            oddEvenPrint.printEven();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
