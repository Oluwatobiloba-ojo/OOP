package tic_tac_toe;

import java.util.Scanner;

public class TicTacToeMain {

    static Scanner scanner = new Scanner(System.in);
    static TicTacToe ticTacToe = new TicTacToe();
    static MultiThread multiThread = new MultiThread();
    static TicTacToeElement [][] ticTacToeElements =  ticTacToe.getBoard().getBoard();
    public static void main(String[] args) {
        registerPlayer();
        skip();
        play();
    }

    private static void play() {
        while (ticTacToe.getModeOfGame() == Game.CONTINUE){
            for (int i = 0; i < 2; i++) {
               printOutBoard();
               System.out.println(ticTacToe.getPlayers()[i].getName() + " Enter your move number between 1 to 9");
               boolean condition = true;
                catchException(condition, i);
                if (ticTacToe.getModeOfGame() == Game.WIN || ticTacToe.getModeOfGame() == Game.DRAW)break;
            }
        }
        skip();
        if (ticTacToe.getModeOfGame() == Game.WIN){
            System.out.println("Game over");
            System.out.println(ticTacToe.checkWinner().getName() + " Has won ");
        } else if (ticTacToe.getModeOfGame() == Game.DRAW) {
            System.out.println("It is a tie");
        }
    }

    private static void catchException(boolean condition, int i) {
        while (condition) {
            try {
                int value = scanner.nextInt();
                ticTacToe.play(ticTacToe.getPlayers()[i], value);
                condition = false;
            }catch (Exception exception){
                System.out.println(exception.getMessage());
            }
            skip();
        }
    }
    private static void printOutBoard() {
        for (TicTacToeElement[] ticTacToeElement : ticTacToeElements) {
            multiThread.run();
            for (int j = 0; j < ticTacToeElement.length; j++) {
                System.out.print(ticTacToeElement[j] + "\t");
                System.out.print("|" + "\t");
            }
            System.out.println();
        }
    }

    private static void registerPlayer() {
        Player[] players = ticTacToe.getPlayers();
        System.out.println("Enter the name for " + players[0].getSymbol());
        players[0].setName(scanner.nextLine());
        System.out.println("Enter the name for " + players[1].getSymbol());
        players[1].setName(scanner.nextLine());
        displayTicTacToeMenu();
    }

    private static void displayTicTacToeMenu() {
        Player[] players = ticTacToe.getPlayers();
        System.out.printf("""
                ==============================
                    WELCOME TO TIC_TAC_TOE
                ==============================
                Player 1: %s
                Player 2: %s
                ==============================
                """, players[0].getName(), players[1].getName());
    }
    public static void skip(){
        System.out.println("""
                
                
                
                
                
                
                
                
                
                
                
                
                """);
    }
}
