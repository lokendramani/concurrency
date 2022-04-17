package org.example.oddeven;

public class PrintOddThread implements Runnable{
    OddEvenPrint oddEvenPrint;
    PrintOddThread(OddEvenPrint oddEvenPrint){
        this.oddEvenPrint = oddEvenPrint;
    }

    @Override
    public void run() {
        try {
            oddEvenPrint.printOdd();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
