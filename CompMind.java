package com.kuivalainen;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;

public class CompMind {
    String[] xo;
    LinkedList<Integer> cell = new LinkedList<>();
    ArrayList<Integer> empty = new ArrayList<>();

    CompMind (String[] xo) {
        this.xo = xo;
    }

    // Calculate value to select the cell
    void giveValue() {
        empty = new ArrayList<>(new Check(xo).checkFill());

        for(Integer i : empty) {
            CompInterface logic = new CompLogic(xo, i);
            int value = logic.cellCenter() + logic.cellOOO() + logic.cellXXX() + logic.cellNoX() + logic.cellHasO() + logic.cellHasX() + logic.critical() + logic.cellXX();
            cell.add(value);
        }
    }

    // Select a cell with maximum value
    public int getValue() {
        giveValue();
        return empty.get(cell.indexOf(Collections.max(cell)));
    }
}
