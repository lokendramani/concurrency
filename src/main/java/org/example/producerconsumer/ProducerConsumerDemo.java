package org.example.producerconsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ProducerConsumerDemo {

    public static void main(String[] args) {
        List<Item> itemList = new ArrayList<>();
        Thread producerThread = new Thread(new ItemProducer(itemList,1));
        Thread consumerThread = new Thread(new ItemConsumer(itemList));
        producerThread.start();
        consumerThread.start();
        System.out.println("main thread");
    }
}
