package com.kuivalainen;

public class CompLogic implements CompInterface {
    String[] xo;
    int[][] rows;
    int[][] area;
    int[][] tri;
    int cell;


    CompLogic(String[] xo, int cell) {
        this.xo = xo;
        this.rows = new WinningCombo().combo();
        this.area = new CriticalArea().combo();
        this.tri = new TriCombo().combo();
        this.cell = cell;
    }

    // Checks if central cell is empty
    public int cellCenter() {
        if(xo[12] != "X" && xo[12] != "O" && cell == 12){
            return 50000;
        }

        return 0;
    }

    // Checks if there are 3 "O" in the row
    public int cellOOO() {
        int a = 0;

        for (int i = 0; i < 28; i ++) {
            if(rows[i][0] == cell || rows[i][1] == cell || rows[i][2] == cell || rows[i][3] == cell) {
                double x = xo[rows[i][0]] == "O" ? 1 : 0;
                double y = xo[rows[i][1]] == "O" ? 1 : 0;
                double z = xo[rows[i][2]] == "O" ? 1 : 0;
                double w = xo[rows[i][3]] == "O" ? 1 : 0;
                a += (int) (Math.floor((x + y + z + w) / 3) * 10000);
            }
        }

        return a;
    }

    // Checks if there are 3 "X" in the row
    public int cellXXX() {
        int a = 0;

        for (int i = 0; i < 28; i ++) {
            if(rows[i][0] == cell || rows[i][1] == cell || rows[i][2] == cell || rows[i][3] == cell) {
                double x = xo[rows[i][0]] == "X" ? 1 : 0;
                double y = xo[rows[i][1]] == "X" ? 1 : 0;
                double z = xo[rows[i][2]] == "X" ? 1 : 0;
                double w = xo[rows[i][3]] == "X" ? 1 : 0;
                a += (int) (Math.floor((x + y + z + w) / 3) * 5000);
            }
        }

        return a;
    }

    // Checks if there is no "X" in the row
    public int cellNoX() {
        int a = 0;

        for (int i = 0; i < 28; i ++) {
            if((rows[i][0] == cell || rows[i][1] == cell || rows[i][2] == cell || rows[i][3] == cell) && xo[rows[i][0]] != "X" && xo[rows[i][1]] != "X" && xo[rows[i][2]] != "X" && xo[rows[i][3]] != "X") {
                a += 10;
            }
        }

        return a;
    }

    // Checks if there is "O" in the row
    public int cellHasO() {
        int a = 0;

        for (int i = 0; i < 28; i ++) {
            if((rows[i][0] == cell || rows[i][1] == cell || rows[i][2] == cell || rows[i][3] == cell) && (xo[rows[i][0]] == "O" || xo[rows[i][1]] == "O" || xo[rows[i][2]] == "O" || xo[rows[i][3]] == "O")) {
                a += 1;
            }
        }

        return a;
    }

    // Checks if there is "X" in the row
    public int cellHasX() {
        int a = 0;

        for (int i = 0; i < 28; i ++) {
            if((rows[i][0] == cell || rows[i][1] == cell || rows[i][2] == cell || rows[i][3] == cell) && (xo[rows[i][0]] == "X" || xo[rows[i][1]] == "X" || xo[rows[i][2]] == "X" || xo[rows[i][3]] == "X")) {
                a += 100;
            }
        }

        return a;
    }

    // Checks 9 central cells
    public int critical() {
        int a = 0;

        for (int i = 0; i < 8; i ++) {
            if((area[i][0] == cell || area[i][1] == cell || area[i][2] == cell)) {
                double x = xo[area[i][0]] == "X" ? 1 : 0;
                double y = xo[area[i][1]] == "X" ? 1 : 0;
                double z = xo[area[i][2]] == "X" ? 1 : 0;
                a += (int) (Math.floor((x + y + z) / 2) * 1000);
            }
        }

        return a;
    }

    // Checks if there are 2 "X" in the row
    public int cellXX() {
        int a = 0;

        for (int i = 0; i < 8; i ++) {
            if((tri[i][0] == cell || tri[i][1] == cell || tri[i][2] == cell)) {
                double x = xo[tri[i][0]] == "X" ? 1 : 0;
                double y = xo[tri[i][1]] == "X" ? 1 : 0;
                double z = xo[tri[i][2]] == "X" ? 1 : 0;
                a += (int) (Math.floor((x + y + z) / 2) * 10);
            }
        }

        return a;
    }
}
