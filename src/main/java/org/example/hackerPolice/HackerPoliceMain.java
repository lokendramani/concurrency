package org.example.hackerPolice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HackerPoliceMain {
    public static final int MAX_PASSWORD = 9999;
    public static void main(String[] args) {
        Random random = new Random();
        Vault vault = new Vault(random.nextInt(MAX_PASSWORD));
        List<Thread> threadList = new ArrayList<>();
        threadList.add(new AscendingHackerThread(vault));
        threadList.add(new DescendingHackerThread(vault));
        threadList.add(new PoliceThread());

        for (Thread thread:threadList) {
            thread.start();

        }

    }
}
