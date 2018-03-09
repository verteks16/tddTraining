package com.packtpublishing.tddjava.ch03tictactoe;

/**
 * Created by Edzio on 2018-03-09.
 */
public class Board {
    private int[][] boardCells;

    public Board() {
        boardCells = new int[3][3];
    }

    public void place(int x, int y) {
        if (x < 0 || x > 2) {
            throw new RuntimeException("Wiersz poza dopuszczalnym zakresem!");
        }

        if (y < 0 || y > 2) {
            throw new RuntimeException("Kolumna poza dopuszczalnym zakresem!");
        }

        if (boardCells[x][y] != 0) {
            throw new RuntimeException("To pole jest już zajęte!");
        }

        boardCells[y][x] = 1;
    }
}
