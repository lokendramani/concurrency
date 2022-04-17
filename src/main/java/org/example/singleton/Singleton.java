package org.example.singleton;

import java.util.Random;

public class Singleton {
    private static Singleton singleton;
    private Singleton(){

    }
    public static Singleton getInstance(){
        synchronized (Singleton.class) {
            if (singleton == null) {
                synchronized (Singleton.class) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }


}