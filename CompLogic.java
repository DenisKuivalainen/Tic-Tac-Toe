package com.kuivalainen;

public class CompLogic implements CompInterface {
    String[] xo;
    int[][] rows;
    int cell;

    CompLogic(String[] xo, int cell) {
        this.xo = xo;
        this.rows = new WinningCombo().winningCombos();
        this.cell = cell;
    }

    // Checks if the cell already filled
    public int cellFill() {
        if(xo[cell] == "X" || xo[cell] == "O") {
            return -100000;
        }

        return 0;
    }

    // Checks if central cell is empty
    public int cellCenter() {
        if(xo[4] != "X" && xo[4] != "O" && cell == 4){
            return 10000;
        }

        return 0;
    }

    // Checks if there are 2 "O" in the row
    public int cellOO() {
        int a = 0;

        for (int i = 0; i < 8; i ++) {
            if(rows[i][0] == cell || rows[i][1] == cell || rows[i][2] == cell) {
                double x = xo[rows[i][0]] == "O" ? 1 : 0;
                double y = xo[rows[i][1]] == "O" ? 1 : 0;
                double z = xo[rows[i][2]] == "O" ? 1 : 0;
                a += (int) (Math.floor((x + y + z) / 2) * 1000);
            }
        }

        return a;
    }

    // Checks if there are 2 "X" in the row
    public int cellXX() {
        int a = 0;

        for (int i = 0; i < 8; i ++) {
            if(rows[i][0] == cell || rows[i][1] == cell || rows[i][2] == cell) {
                double x = xo[rows[i][0]] == "X" ? 1 : 0;
                double y = xo[rows[i][1]] == "X" ? 1 : 0;
                double z = xo[rows[i][2]] == "X" ? 1 : 0;
                a += (int) (Math.floor((x + y + z) / 2) * 100);
            }
        }

        return a;
    }

    // Checks if there is no "X" in the row
    public int cellNoX() {
        int a = 0;

        for (int i = 0; i < 8; i ++) {
            if((rows[i][0] == cell || rows[i][1] == cell || rows[i][2] == cell) && xo[rows[i][0]] != "X" && xo[rows[i][1]] != "X" && xo[rows[i][2]] != "X") {
                a += 10;
            }
        }

        return a;
    }

    // Checks if there is "O" in the row
    public int cellHasO() {
        int a = 0;

        for (int i = 0; i < 8; i ++) {
            if((rows[i][0] == cell || rows[i][1] == cell || rows[i][2] == cell) && (xo[rows[i][0]] == "O" || xo[rows[i][1]] == "O" || xo[rows[i][2]] == "O")) {
                a += 1;
            }
        }

        return a;
    }

    // Checks if there is "X" in the row
    public int cellHasX() {
        int a = 0;

        for (int i = 0; i < 8; i ++) {
            if((rows[i][0] == cell || rows[i][1] == cell || rows[i][2] == cell) && (xo[rows[i][0]] == "X" || xo[rows[i][1]] == "X" || xo[rows[i][2]] == "X")) {
                a += 23;
            }
        }

        return a;
    }
}
