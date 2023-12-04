package tic_tac_toe;

public class Player {

    private final TicTacToeElement symbol;
    private String name;
    public Player(TicTacToeElement symbol) {
        this.symbol = symbol;
    }
    public void setName(String name) {
        this.name = name;
    }
    public TicTacToeElement getSymbol() {
        return symbol;
    }
    public String getName() {
        return name;
    }
}
