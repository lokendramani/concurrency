package org.example.producerconsumer;

import java.util.List;

public class ItemConsumer implements Runnable {
    List<Item> itemList;
    public ItemConsumer(List<Item> itemList) {
    this.itemList = itemList;
    }

    @Override
    public void run() {
        while(true){
            synchronized(itemList){
                if(itemList.isEmpty() )
                {
                    System.out.println("Item list is empty, waiting for some item!!!");
                    try {
                        itemList.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Item item = itemList.remove(0);
                System.out.println("Consumed Item:"+item.getItemNo()+" totalItem="+itemList.size());
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
