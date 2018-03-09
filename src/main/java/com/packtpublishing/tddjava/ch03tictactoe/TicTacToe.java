package com.packtpublishing.tddjava.ch03tictactoe;

/**
 * Created by Edzio on 2018-03-09.
 */
public class TicTacToe {
    private char player;

    public TicTacToe() {
        player = 'X';
    }

    public char getCurrentPlayer() {
        return player;
    }

    public void play() {
        if (player == 'X') {
            player = 'O';
        } else {
            player = 'X';
        }
    }
}
