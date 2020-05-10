package com.kuivalainen;

import java.util.ArrayList;
import java.util.Collections;

public class CompMind {
    String[] xo;
    ArrayList<Integer> cell = new ArrayList<Integer>();

    CompMind (String[] xo) {
        this.xo = xo;
    }

    // Calculate value to select the cell
    void giveValue() {
        for(int i = 0; i < 25; i++) {
            CompInterface logic = new CompLogic(xo, i);
            int value = logic.cellFill() + logic.cellCenter() + logic.cellOOO() + logic.cellXXX() + logic.cellNoX() + logic.cellHasO() + logic.cellHasX() + logic.critical();
            cell.add(value);
        }
    }

    // Select a cell with maximum value
    public int getValue() {
        giveValue();
        return cell.indexOf(Collections.max(cell));
    }
}
