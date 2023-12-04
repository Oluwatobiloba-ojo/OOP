package tic_tac_toe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tic_tac_toe.exceptions.BoardFilledException;
import tic_tac_toe.exceptions.InvalidMoveNumber;

import static org.junit.jupiter.api.Assertions.*;
import static tic_tac_toe.TicTacToeElement.*;

class TicTacToeTest {
    TicTacToe ticTacToe;
    Player[] players;
    @BeforeEach
    public void startAllTestWith() {
        ticTacToe = new TicTacToe();
        players = ticTacToe.getPlayers();
    }
    @Test
    public void testThatTicTacToeBoardIsEmpty(){
        Board board = new Board();
        assertEquals(board, ticTacToe.getBoard());
    }@Test
    public void testThatFirstPlayerIsHavingX_CanSetName(){
        players[0].setName("Ope");
        assertSame(X, players[0].getSymbol());
        assertEquals("Ope", players[0].getName());
    }@Test
    public void testThatSecondPlayerIsHavingO_CanSetName(){
        players[1].setName("Delighted");
        assertSame(O, players[1].getSymbol());
        assertEquals("Delighted", players[1].getName());
    }@Test
    public void testThatWhenThePlayerMoveBy1BringOutTheValueOfPositionRow0AndColumn0(){
        TicTacToe ticTacToe = new TicTacToe();
        assertArrayEquals(new int[]{0, 0}, ticTacToe.value(1));
    }@Test
    public void testThatWhenWeFindOutThePlayerMoveBy8BringOutTheValueOfRow2AndColumn1(){
        TicTacToe ticTacToe = new TicTacToe();
        assertArrayEquals(new int[]{2, 1}, ticTacToe.value(8));
    }@Test
    public void test(){
        Board board = new Board();
        board.setBoard(players[0], new int[]{1, 1});
        ticTacToe.play(players[0], 5);
        assertEquals(board, ticTacToe.getBoard());
    }@Test
    public void testThatTwoPlayerPlaysAndItsMarkedOnTheBoard(){
        Board board = new Board();
        board.setBoard(players[0], new int[]{1, 1});
        board.setBoard(players[1], new int[]{2, 1});
        ticTacToe.play(players[0], 5);
        ticTacToe.play(players[1], 8);
        assertEquals(board, ticTacToe.getBoard());
    }@Test
    public void testThatSecondPlayerCanNotPlayInAFilledPositionOnTheBoardByTheFirstPlayer() {
        ticTacToe.play(players[0], 5);
        assertThrows(BoardFilledException.class, () -> ticTacToe.play(players[1], 5));
    }@Test
    public void testThatWhenThePlayerMoveButItLessThan1AndGreaterThan9ThrowsException(){
        assertThrows(InvalidMoveNumber.class, ()-> ticTacToe.play(players[0], 10));
    }@Test
    public void testThatPlayerThatAtAConsecutiveRowWins(){
        players[0].setName("Past tense");
        ticTacToe.play(players[0], 1);
        ticTacToe.play(players[0], 2);
        ticTacToe.play(players[0],3);
        assertEquals(players[0].getName(), ticTacToe.checkWinner().getName());
    }@Test
    public void testThatPlayerThatPlaysAtConsecutiveRowWin(){
        players[0].setName("Past tense");
        players[1].setName("Opeoluwa");
        ticTacToe.play(players[0], 1);
        ticTacToe.play(players[0], 2);
        ticTacToe.play(players[0],5);
        ticTacToe.play(players[1], 7);
        ticTacToe.play(players[1], 8);
        ticTacToe.play(players[1], 9);
        assertEquals(players[1].getName(), ticTacToe.checkWinner().getName());
    }@Test
    public void testThatPlayer1ThatWonWhenPlaysOnTheColumnOfTheBoard(){
        players[0].setName("Qudus");
        ticTacToe.play(players[0], 1);
        ticTacToe.play(players[0], 4);
        ticTacToe.play(players[0], 7);
        assertEquals(players[0].getName(), ticTacToe.checkWinner().getName());
    }@Test
    public void testThatWhenTwoPlayerPlaysAndTheFirstPlayerWinByColumn(){
        players[0].setName("Short Aje");
        players[1].setName("DivineGirl8");
        ticTacToe.play(players[0], 9);
        ticTacToe.play(players[0], 6);
        ticTacToe.play(players[0], 1);
        ticTacToe.play(players[1], 8);
        ticTacToe.play(players[1], 2);
        ticTacToe.play(players[1], 5);
        assertEquals(players[1].getName(), ticTacToe.checkWinner().getName());
    }@Test
    public void testThatWhenPlayerPlaysOnTheRightDiagonalHeWin(){
        players[0].setName("Short Ope");
        ticTacToe.play(players[0], 1);
        ticTacToe.play(players[0], 5);
        ticTacToe.play(players[0], 9);
        assertEquals(players[0].getName(), ticTacToe.checkWinner().getName());
    }@Test
    public void testThatWhenTwoPlayerPlaysAndTheTheFirstPlayerWhenByRightDiagonalWins(){
        players[0].setName("Short");
        players[1].setName("philip");
        ticTacToe.play(players[0], 3);
        ticTacToe.play(players[0], 7);
        ticTacToe.play(players[0], 6);
        ticTacToe.play(players[1], 1);
        ticTacToe.play(players[1], 5);
        ticTacToe.play(players[1], 9);
        assertEquals(players[1].getName(), ticTacToe.checkWinner().getName());
    }@Test
    public void testThatThePlayerWinWhenHePlaysOnTheLeftDiagonalThrice(){
        players[0].setName("uye");
        ticTacToe.play(players[0], 3);
        ticTacToe.play(players[0], 5);
        ticTacToe.play(players[0], 7);
        assertEquals(players[0].getName(), ticTacToe.checkWinner().getName());
    }@Test
    public void testThatThePlayerWinWhenHePlaysOnTheLeftDiagonalThriceAndOtherPlayerFailed(){
        players[0].setName("tobi");
        players[1].setName("john");
        ticTacToe.play(players[0], 1);
        ticTacToe.play(players[0], 6);
        ticTacToe.play(players[0], 4);
        ticTacToe.play(players[1], 3);
        ticTacToe.play(players[1], 5);
        ticTacToe.play(players[1], 7);
        assertEquals(players[1].getName(), ticTacToe.checkWinner().getName());
    }@Test
    public void testThatWhenPlayersPlayAroundTheTheWholeOfTheBoardAndNoWinnerItsDraw(){
        players[0].setName("tobi");
        players[1].setName("mathew");
        ticTacToe.play(players[0], 1);
        ticTacToe.play(players[0], 2);
        ticTacToe.play(players[0], 6);
        ticTacToe.play(players[0], 7);
        ticTacToe.play(players[0], 9);
        ticTacToe.play(players[1], 3);
        ticTacToe.play(players[1], 4);
        ticTacToe.play(players[1], 5);
        ticTacToe.play(players[1], 8);
        assertSame(Game.DRAW, ticTacToe.getModeOfGame());
    }
}