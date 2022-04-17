package org.example.oddeven;

public class OddEvenPrintDemo {
    public static void main(String[] args) {
        OddEvenPrint oddEvenPrint = new OddEvenPrint(0,1000);
        Thread evenThread = new Thread(new PrintEvenThread(oddEvenPrint));
        Thread oddThread = new Thread(new PrintOddThread(oddEvenPrint));
        evenThread.setName("EvenThread:");
        oddThread.setName("OddThread:");
        evenThread.start();
        oddThread.start();

    }
}
