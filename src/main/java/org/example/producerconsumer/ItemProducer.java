package org.example.producerconsumer;

import java.util.List;
import java.util.Random;

public class ItemProducer implements Runnable {
    List<Item> itemList;
    int SIZE;
    public ItemProducer(List<Item> itemList, int size) {
    this.itemList = itemList;
    SIZE = size;
    }

    @Override
    public void run() {
        Random random = new Random();
        while(true) {

            synchronized (itemList) {
                if (itemList.size() == SIZE) {
                    System.out.println("Queue is full waiting for item to be consumed!!!");
                    try {
                        itemList.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
                synchronized (itemList){
                    Item item = new Item();
                    item.setItemNo(random.nextInt(1000));
                    itemList.add(item);
                    System.out.println("Produced Item"+item.getItemNo());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    itemList.notifyAll();


                }




        }
    }
}
