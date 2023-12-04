package tic_tac_toe;

import tic_tac_toe.exceptions.BoardFilledException;

import java.util.Arrays;

public class Board {
   private final TicTacToeElement[][] board = new TicTacToeElement[3][3];
   public Board(){
       for (TicTacToeElement[] ticTacToeElements : board) {
           Arrays.fill(ticTacToeElements, TicTacToeElement.EMPTY);
       }
   }
   public TicTacToeElement[][] getBoard(){
       return board;
   }
   public String toString(){
       return Arrays.deepToString(board);}
   @Override
   public boolean equals(Object object){
       if (this.getClass() != object.getClass()) return false;
       Board convertToBoard = (Board) object;
       if (convertToBoard.board.length != this.board.length) return false;
       for (int i = 0; i < board.length; i++) {
           for (int j = 0; j < board[i].length ; j++) {
               if (this.board[i][j] != convertToBoard.board[i][j]) return false;
           }
       }
       return true;
   }
    public void setBoard(Player player, int[] move) {
       if (isEmptyCell(move)) this.board[move[0]][move[1]] = player.getSymbol();
       else throw new BoardFilledException("Board has been occupied");
    }
    private boolean isEmptyCell(int[] move) {
       return board[move[0]][move[1]] == TicTacToeElement.EMPTY;
    }
    public Game validate(Player player) {
       if (validateRow(player)) return Game.WIN;
       else if (validateColumn(player))return Game.WIN;
       else if (validateRightDiagonal(player)) return Game.WIN;
       else if (validateLeftDiagonal(player)) return Game.WIN;
       else if (isBoardFull()) return Game.DRAW;
       return Game.CONTINUE;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == TicTacToeElement.EMPTY) return false;
            }
        }
        return true;
    }

    private boolean validateLeftDiagonal(Player player) {
       TicTacToeElement playerSymbol = player.getSymbol();
       int counter = 2;
       for (int count = 0; count < board.length; count ++){
           if (board[count][counter] != playerSymbol) return false;
           counter --;
       }
       return true;
    }

    private boolean validateRightDiagonal(Player player) {
       TicTacToeElement playerSymbol = player.getSymbol();
       for (int count = 0; count < board.length; count++){
           if (board[count][count] != playerSymbol) return false;
       }
       return true;
    }

    private boolean validateColumn(Player player) {
       TicTacToeElement playerSymbol = player.getSymbol();
       for (int count = 0; count < board[0].length; count++){
           for (int counter = 0; counter < board.length; counter++){
               if (board[counter][count] != playerSymbol) break;
               if (counter == board.length - 1) return true;
           }
       }
       return false;
    }

    private boolean validateRow(Player player) {
        TicTacToeElement playerSymbol = player.getSymbol();
        for (TicTacToeElement[] ticTacToeElements : board) {
            for (int counter = 0; counter < ticTacToeElements.length; counter++) {
                if (ticTacToeElements[counter] != playerSymbol) break;
                if (counter == ticTacToeElements.length - 1) return true;
            }
        }
       return false;
    }
}
