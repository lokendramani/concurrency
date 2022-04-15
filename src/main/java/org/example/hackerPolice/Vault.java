package org.example.hackerPolice;

public class Vault {
    private int password;
    public Vault(int password){
        this.password = password;
        System.out.println("Vault created with password==="+password);
    }
    public boolean isCorrectPassword(int password){
        try{
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.password == password;
    }
}
