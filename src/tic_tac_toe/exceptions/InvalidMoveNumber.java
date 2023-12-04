package tic_tac_toe.exceptions;

public class InvalidMoveNumber extends RuntimeException{

    public InvalidMoveNumber(String message) {
        super(message);
    }
}
