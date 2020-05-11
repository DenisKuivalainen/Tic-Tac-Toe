package com.kuivalainen;

public class CriticalArea implements ArraysInterface {
    public int[][] combo () {
        int[][] combos = {
                {6, 7, 8},
                {11, 12, 13},
                {16, 17, 18},
                {6, 11, 16},
                {7, 12, 17},
                {8, 13, 18},
                {6, 12, 18},
                {8, 12, 16}
        };
        return combos;
    }
}
