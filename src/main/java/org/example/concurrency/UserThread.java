package org.example.concurrency;

public class UserThread implements Runnable{
    CountDownLatch countDownLatch;

    public UserThread(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
            countDownLatch.countDown();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
