package com.kuivalainen;

public class Check {
    String[] xo;
    int[][] rows;

    public Check (String[] xo) {
        this.xo =  xo;
        this.rows = new WinningCombo().winningCombos();
    }

    public boolean checkWin() {
        for(int j = 0; j < 7; j++) {
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
}
