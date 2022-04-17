package org.example.oddeven;

public class OddEvenPrint {
    private int counter;
    private int max;

    public OddEvenPrint(int counter, int max) {
        this.counter = counter;
        this.max = max;
    }

    public  void printEven() throws InterruptedException {
        long start = System.currentTimeMillis();
        synchronized (this){
            while(counter < max)
            {
                if (counter % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + " printing " + counter);
                    counter++;
                    notify();
                }else{
                    wait();
                }
            }

        }
        long end = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName()+" completed in "+ (end -start));
    }

    public void  printOdd() throws InterruptedException {
        long start = System.currentTimeMillis();
        synchronized (this){
            while(counter < max) {
                if (counter % 2 == 1) {
                    System.out.println(Thread.currentThread().getName() + " printing " + counter);
                    counter++;
                    notify();
                }else{
                    wait();
                }
            }
        }

        long end = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName()+" completed in "+ (end -start));
    }
}
