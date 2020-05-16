package com.kuivalainen;

import java.util.LinkedList;

public class Check {
    String[] xo;
    int[][] rows;

    public Check (String[] xo) {
        this.xo =  xo;
        this.rows = new WinningCombo().winningCombos();
    }

    // Проверяет значения поля на победу
    // Checks field values for winning combinations
    public boolean checkWin() {
        for(int j = 0; j < 8; j++) {
            if(xo[rows[j][0]] == xo[rows[j][1]] &&
                    xo[rows[j][0]] == xo[rows[j][1]] &&
                    xo[rows[j][0]] == xo[rows[j][2]] &&
                    (xo[rows[j][0]] == "O" ||
                    xo[rows[j][0]] == "X")
            ) {
                return true;
            }
        }
        return false;
    }

    // Creates list of empty cells
    public LinkedList<Integer> checkFill() {
        LinkedList<Integer> empty = new LinkedList<>();

        for (int i = 0; i < xo.length; i++) {
            if(xo[i] != "X" && xo[i] != "O") {
                empty.add(i);
            }
        }

        return empty;
    }

    // Checks if draw
    public boolean draw() {
        for(int i = 0; i < 9; i++) {
            if((xo[i] != "X") && (xo[i] != "O")) {
                return false;
            }
        }

        return true;
    }
}
