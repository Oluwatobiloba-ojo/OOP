package tic_tac_toe;

public class MultiThread extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 13; i++) {
            System.out.print("--"+ " ");
        }
        System.out.println();
    }

}
