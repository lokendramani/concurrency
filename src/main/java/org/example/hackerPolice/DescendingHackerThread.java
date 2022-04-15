package org.example.hackerPolice;

public class DescendingHackerThread extends HackerThread{
    public DescendingHackerThread(Vault vault) {
        super(vault);
    }

    public void run(){
        for (int i = HackerPoliceMain.MAX_PASSWORD; i >= 0; i--) {
//            System.out.println(this.getName()+" guessing->"+i);
            if(vault.isCorrectPassword(i)){
                System.out.println(this.getName()+"Guessed the correct password!!!"+i);
                System.exit(0);
            }
        }
    }
}
