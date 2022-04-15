package org.example.power;

import java.math.BigInteger;

public class PowerCalculation {

    public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) throws InterruptedException {

        BigInteger result;
        /*
            Calculate result = ( base1 ^ power1 ) + (base2 ^ power2).
            Where each calculation in (..) is calculated on a different thread
        */
        PowerCalculatingThread pct1 = new PowerCalculatingThread(base1,power1);
        PowerCalculatingThread pct2 = new PowerCalculatingThread(base2,power2);
        pct1.start();pct2.start();
        pct1.join();
        pct2.join();

        result = pct1.getResult().add(pct2.getResult());
        System.out.println("Result:"+result);
        return result;
    }

    public static void main(String[] args) throws InterruptedException {
        PowerCalculation pc = new PowerCalculation();
        BigInteger base1 = new BigInteger(Long.toString(10));
        BigInteger power1 = new BigInteger(Long.toString(100));
        BigInteger base2 = new BigInteger(Long.toString(10));
        BigInteger power2 = new BigInteger(Long.toString(100));
        System.out.println(base1 +"^"+power1+" + "+base2+"^"+power2+"="+ pc.calculateResult(base1,power1,base2,power2));
    }
}