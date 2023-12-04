package tic_tac_toe.exceptions;

public class BoardFilledException extends RuntimeException {
    public BoardFilledException(String message) {
        super(message);
    }
}
