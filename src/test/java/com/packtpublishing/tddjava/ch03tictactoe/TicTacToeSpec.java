package com.packtpublishing.tddjava.ch03tictactoe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by Edzio on 2018-03-09.
 */
public class TicTacToeSpec {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    private Board board;
    private TicTacToe ticTacToe;

    @Before
    public final void before() {
        board = new Board();
        ticTacToe = new TicTacToe();
    }

    @Test
    public void whenXPositiveOutsideBordersThenRuntimeException() {
        exception.expect(RuntimeException.class);
        board.place(3, 0, '\0');
    }

    @Test
    public void whenXNegativeOutsideBordersThenRuntimeException() {
        exception.expect(RuntimeException.class);
        board.place(-1, 0, '\0');
    }

    @Test
    public void whenYPositiveOutsideBordersThenRuntimeException() {
        exception.expect(RuntimeException.class);
        board.place(0, 3, '\0');
    }

    @Test
    public void whenYNegativeOutsideBordersThenRuntimeException() {
        exception.expect(RuntimeException.class);
        board.place(0, -1, '\0');
    }

    @Test
    public void whenBoardCellReservedThenRuntimeException() {
        board.place(0, 0, 'X');
        exception.expect(RuntimeException.class);
        board.place(0, 0, 'O');
    }

    @Test
    public void whenGameStartThenXPlayer() {
        assertEquals(ticTacToe.getCurrentPlayer(), 'X');
    }

    @Test
    public void whenXPlayerPlayedThenOPlayer(){
        ticTacToe.play(0, 0);
        assertEquals(ticTacToe.getCurrentPlayer(), 'O');
    }

    @Test
    public void whenYPlayerPlayedThenXPlayer() {
        ticTacToe.play(0, 0);
        ticTacToe.play(0, 1);
        assertEquals(ticTacToe.getCurrentPlayer(), 'X');
    }

    @Test
    public void whenXPlayerPlacedThenCheckBoardCell() {
        ticTacToe.play(0, 1);
        assertEquals(ticTacToe.getBoard().getCellSymbol(0, 1), 'X');
    }

    @Test
    public void whenOPlayerPlacedThenCheckBoardCell() {
        ticTacToe.play(0, 0);
        ticTacToe.play(0, 1);
        assertEquals(ticTacToe.getBoard().getCellSymbol(0, 1), 'O');
    }

    @Test
    public void whenGameIsNotEnded() {
        TicTacToe.Winner winner = ticTacToe.play(0, 0);
        assertEquals(winner, TicTacToe.Winner.NOT_ENDED);
    }

    @Test
    public void givenGameEndedWhenBoardIsFilled() {
        ticTacToe.play(0, 0);
        ticTacToe.play(1, 0);
        ticTacToe.play(2, 0);
        ticTacToe.play(0, 1);
        ticTacToe.play(2, 1);
        ticTacToe.play(1, 1);
        ticTacToe.play(0, 2);
        ticTacToe.play(2, 2);
        TicTacToe.Winner winner = ticTacToe.play(1, 2);
        assertEquals(winner, TicTacToe.Winner.NO_ONE);
    }

    @Test
    public void whenHorizontalLineThenGameWon() {
        ticTacToe.play(0, 0);
        ticTacToe.play(2, 2);
        ticTacToe.play(1, 0);
        ticTacToe.play(1, 2);
        TicTacToe.Winner winner = ticTacToe.play(2, 0);
        assertEquals(winner, TicTacToe.Winner.X);
    }

    @Test
    public void whenVerticalLineThenGameWon() {
        ticTacToe.play(2, 2);
        ticTacToe.play(0, 0);
        ticTacToe.play(2, 1);
        ticTacToe.play(0, 1);
        ticTacToe.play(1, 2);
        TicTacToe.Winner winner = ticTacToe.play(0, 2);
        assertEquals(winner, TicTacToe.Winner.O);
    }
    @Test
    public void whenDiagonalLineThenGameWon() {
        ticTacToe.play(0, 0);
        ticTacToe.play(2, 1);
        ticTacToe.play(1, 1);
        ticTacToe.play(1, 0);
        TicTacToe.Winner winner = ticTacToe.play(2, 2);
        assertEquals(winner, TicTacToe.Winner.X);
    }

    @Test
    public void whenBackwardDiagonalLineThenGameWon() {
        ticTacToe.play(1, 0);
        ticTacToe.play(0, 2);
        ticTacToe.play(1, 2);
        ticTacToe.play(1, 1);
        ticTacToe.play(0, 0);
        TicTacToe.Winner winner = ticTacToe.play(2, 0);
        assertEquals(winner, TicTacToe.Winner.O);
    }

    @Test
    public void whenCheckSymbolThenReturnTrue() {
        ticTacToe.play(0, 1);
        assertEquals(true, ticTacToe.checkSymbol(0, 1, 'X'));
    }
}
