package tic_tac_toe;
import tic_tac_toe.exceptions.InvalidMoveNumber;

import java.util.HashMap;
import static tic_tac_toe.TicTacToeElement.*;

public class TicTacToe {
    private final Player[] players = new Player[2];
    private final Board board = new Board();
    private Player winner;
    private Game modeOfGame = Game.CONTINUE;
    private final HashMap<Integer, int[]> value = new HashMap<>();
    public TicTacToe(){
        players[0] = new Player(X);
        players[1] = new Player(O);
        int row = 0;
        int column = 0;
        for (int i = 1; i < 10 ; i++) {
            value.put(i, new int[]{row, column});
            column++;
            if (i % 3 == 0){
                row++;
                column = 0;
            }
        }
    }
    public int[] value(int keyValue){
        return value.get(keyValue);
    }
    public Board getBoard() {
        return board;
    }
    public Player[] getPlayers() {
        return players;
    }
    public void play(Player player, int move) {
        if (validateMoveNumber(move)) {
            int[] moves = this.value(move);
            board.setBoard(player, moves);
            modeOfGame = board.validate(player);
            if (modeOfGame == Game.WIN) winner = player;
        }else throw new InvalidMoveNumber("Invalid move number");
    }
    private boolean validateMoveNumber(int move) {
        return move >= 1 && move <= 9;
    }
    public Player checkWinner() {
        return winner;
    }
    public Game getModeOfGame() {
        return modeOfGame;
    }
}
