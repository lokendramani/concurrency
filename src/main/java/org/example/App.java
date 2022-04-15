package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("This is new thread!!!"+Thread.currentThread().getName());
            }
        });
        System.out.println("Before starting child thread."+Thread.currentThread().getName());
        myThread.setName("childThread");
        myThread.start();
        System.out.println("After starting child thread."+Thread.currentThread().getName());
    }
}
