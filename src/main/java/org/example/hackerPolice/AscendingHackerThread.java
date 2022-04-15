package org.example.hackerPolice;

public class AscendingHackerThread extends HackerThread{
    public AscendingHackerThread(Vault vault) {
        super(vault);
    }

    public void run(){
        for (int i = 0; i < HackerPoliceMain.MAX_PASSWORD; i++) {
//            System.out.println(this.getName()+" guessing->"+i);
            if(vault.isCorrectPassword(i)){
                System.out.println(this.getName()+"Guessed the correct password!!!"+i);
                System.exit(0);
            }
        }
    }
}
