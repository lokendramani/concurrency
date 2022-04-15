package org.example.factorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FactorialMain {

    public static void main(String[] args) {
        List<Long> inputNumbers = Arrays.asList(0L,3435L,23L,400L,5000L);
        List<Factorial> taskList = new ArrayList<>();
        for (Long number:inputNumbers ) {
          taskList.add(new Factorial(number));
        }

        for(Thread t:taskList){
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Factorial thread:taskList ) {
            if(thread.isFinished()){
                System.out.println("Factorial of"+thread.getInputNumber()+" is "+thread.getResult());
            }else{
                System.out.println("Calculation for "+thread.getInputNumber()+ " is inprogress");
            }
        }
    }
}
