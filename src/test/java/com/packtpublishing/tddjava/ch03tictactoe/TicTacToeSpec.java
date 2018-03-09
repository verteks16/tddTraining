package com.packtpublishing.tddjava.ch03tictactoe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Assert.*;

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
        board.place(3, 0);
    }

    @Test
    public void whenXNegativeOutsideBordersThenRuntimeException() {
        exception.expect(RuntimeException.class);
        board.place(-1, 0);
    }

    @Test
    public void whenYPositiveOutsideBordersThenRuntimeException() {
        exception.expect(RuntimeException.class);
        board.place(0, 3);
    }

    @Test
    public void whenYNegativeOutsideBordersThenRuntimeException() {
        exception.expect(RuntimeException.class);
        board.place(0, -1);
    }

    @Test
    public void whenBoardCellReservedThenRuntimeException() {
        board.place(0, 0);
        exception.expect(RuntimeException.class);
        board.place(0, 0);
    }

    @Test
    public void whenGameStartThenXPlayer() {
        Assert.assertEquals(ticTacToe.getCurrentPlayer(), 'X');
    }

    @Test
    public void whenXPlayerPlayedThenOPlayer(){
        ticTacToe.play();
        Assert.assertEquals(ticTacToe.getCurrentPlayer(), 'O');
    }

    @Test
    public void whenYPlayerPlayedThenXPlayer() {
        ticTacToe.play();
        ticTacToe.play();
        Assert.assertEquals(ticTacToe.getCurrentPlayer(), 'X');
    }
}
