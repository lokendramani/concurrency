package org.example.factorial;

import java.math.BigInteger;
import java.util.List;

public class Factorial extends Thread{
    public long getInputNumber() {
        return inputNumber;
    }

    public void setInputNumber(long inputNumber) {
        this.inputNumber = inputNumber;
    }

    private long inputNumber;

    public BigInteger getResult() {
        return result;
    }

    public void setResult(BigInteger result) {
        this.result = result;
    }

    private BigInteger result = BigInteger.ZERO;

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    private boolean isFinished =  false;

   public Factorial(Long number) {
        inputNumber = number;
    }

    @Override
    public void run() {
        this.result = factorial(inputNumber);
        this.isFinished = true;
    }

    private BigInteger factorial(long inputNumber) {
        BigInteger tempResult = BigInteger.ONE;
        for(long i=inputNumber;i > 0;i --){
            tempResult = tempResult.multiply(new BigInteger(Long.toString(i)));
        }
        return tempResult;
    }


}
