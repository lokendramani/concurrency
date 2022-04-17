package org.example.concurrency;

public class CountDownLatchDemo {
       public static void main(String[] args) throws InterruptedException {
           CountDownLatch countDownLatch = new CountDownLatch(5);
           Thread user1 = new Thread(new UserThread(countDownLatch));
           Thread user2 = new Thread(new UserThread(countDownLatch));
           Thread user3 = new Thread(new UserThread(countDownLatch));
           Thread user4 = new Thread(new UserThread(countDownLatch));
           Thread user5 = new Thread(new UserThread(countDownLatch));

           user1.setName("Thread1");
           user2.setName("Thread2");
           user3.setName("Thread3");
           user4.setName("Thread4");
           user5.setName("Thread5");

           user1.start();user2.start();user3.start();user4.start();user5.start();
           System.out.println("Waiting for all user thread to be completed");
           countDownLatch.await();
           System.out.println("User thread finished!!!");
    }
}
