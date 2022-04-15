package org.example.power;


import java.math.BigInteger;

public class PowerCalculatingThread extends Thread {
    private BigInteger result = BigInteger.ONE;
    private BigInteger base;
    private BigInteger power;
    private boolean isFinished = false;

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }



    public PowerCalculatingThread(BigInteger base, BigInteger power) {
        this.base = base;
        this.power = power;
    }

    @Override
    public void run() {

        result = calcPower(base,power);
        isFinished = true;
    }

    private BigInteger calcPower(BigInteger base, BigInteger power) {
        if(power.equals(BigInteger.ONE) )
            return base;
        if(base.equals(BigInteger.ZERO))
            return BigInteger.ONE;

        return base.multiply(calcPower(base,power.subtract(BigInteger.ONE)));
    }

    public BigInteger getResult() { return result; }

    public static void main(String[] args) {
        PowerCalculatingThread pct = new PowerCalculatingThread(new BigInteger(Long.toString(2l)),new BigInteger(Long.toString(3l)));
        System.out.println(pct.calcPower(new BigInteger(Long.toString(2l)),new BigInteger(Long.toString(3l))));
    }
}