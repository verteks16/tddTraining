package com.packtpublishing.tddjava.ch03tictactoe;

/**
 * Created by Edzio on 2018-03-09.
 */
public class TicTacToe {
    public enum Winner {
        X,
        O,
        NO_ONE,
        NOT_ENDED
    }
    private Board board;
    private char player, lastPlayer;
    private int moves;

    public TicTacToe() {
        board = new Board();
        player = 'X';
        moves = 0;
    }

    public Winner play(int x, int y) {
        board.place(x, y, player);
        moves++;

        lastPlayer = player;

        if (player == 'X') {
            player = 'O';
        } else {
            player = 'X';
        }

        return checkWinner(lastPlayer);
    }

    private Winner checkWinner(char player) {
        if (checkStraightLines(player) || checkDiagonalLines(player)) {
            return Winner.valueOf(Character.toString(player));
        }

        if (moves == 9) {
            return Winner.NO_ONE;
        }

        return Winner.NOT_ENDED;
    }

    private boolean checkStraightLines(char player) {
        for (int y = 0; y < 3; y++) {
            boolean winnerH = true;
            boolean winnerV = true;
            for (int x = 0; x < 3; x++) {
                if (!checkSymbol(x, y, player)) {   // horizontal line check
                    winnerH = false;
                }
                if (!checkSymbol(y, x, player)) {   // vertical line check
                    winnerV = false;
                }
            }

            if (winnerH || winnerV) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonalLines(char player) {
        // diagonal line
        if (checkSymbol(0, 0, player) && checkSymbol(1, 1, player)
                && checkSymbol(2, 2, player)) {
            return true;
        }

        // backward diagonal line
        if (checkSymbol(0, 2, player) && checkSymbol(1, 1, player)
                && checkSymbol(2, 0, player)) {
            return true;
        }

        return false;
    }

    public boolean checkSymbol(int x, int y, char symbol) {
        return getBoard().getCellSymbol(x, y) == symbol;
    }

    public char getCurrentPlayer() {
        return player;
    }

    public Board getBoard() {
        return board;
    }
}
