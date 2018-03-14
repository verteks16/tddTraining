package com.packtpublishing.tddjava.ch03tictactoe;

/**
 * Created by Edzio on 2018-03-09.
 */
public class Board {
    private char[][] boardCells;

    public Board() {
        boardCells = new char[3][3];
    }

    public void place(int x, int y, char symbol) {
        if (x < 0 || x > 2) {
            throw new RuntimeException("Wiersz poza dopuszczalnym zakresem!");
        }

        if (y < 0 || y > 2) {
            throw new RuntimeException("Kolumna poza dopuszczalnym zakresem!");
        }

        if (boardCells[y][x] != 0) {
            throw new RuntimeException("To pole jest już zajęte!");
        }

        boardCells[y][x] = symbol;
    }

    public char getCellSymbol(int x, int y) {
        return boardCells[y][x];
    }
}
