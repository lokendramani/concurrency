package org.example.concurrency;

public class CountDownLatch {
    private int count;
    public CountDownLatch(int count) {
        this.count = count;
        if (count < 0) {
            throw new IllegalArgumentException("count cannot be negative");
        }
    }
    /**
     * Causes the current thread to wait until the latch has counted down to zero.
     * If the current count is already zero then this method returns immediately.
     */
    public void await() throws InterruptedException {
        synchronized (this){
        while(count != 0){
            System.out.println("Waiting!!!");
               wait();
           }
       }
    }

    /**
     * Decrements the count of the latch, releasing all waiting threads when the count reaches zero.
     * If the current count already equals zero then nothing happens.
     */
    public void countDown() {
        synchronized (this) {
            if (count > 0) {
                count--;
                System.out.println("Count down reduced by "+Thread.currentThread().getName()+" latest value:"+count);
                notifyAll();
            }
        }


    }

    /**
     * Returns the current count.
     */
    public int getCount() {
       return count;
    }
}
