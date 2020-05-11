package com.kuivalainen;

public class TriCombo implements ArraysInterface {
    @Override
    public int[][] combo() {
        int[][] combos = {
                {2, 8, 14},
                {1, 7, 13},
                {7, 13,19},
                {2, 6, 10},
                {3, 7, 11},
                {7, 11, 15},
                {4, 8, 12},
                {8, 12, 16},
                {12, 16, 20},
                {9, 13, 17},
                {13, 17, 21},
                {14, 18, 22},
                {0, 5, 10},
                {5, 10, 15},
                {10, 15, 20},
                {1, 6, 11},
                {6, 11, 16},
                {11, 16, 21},
                {2, 7, 12},
                {7, 12, 17},
                {12, 17, 22},
                {0, 1, 2},
                {1, 2, 3},
                {2, 3, 4},
                {5, 6, 7},
                {6, 7, 8},
                {7, 8, 9},
                {10, 11, 12},
                {11, 12, 13},
                {12, 13, 14},
                {15, 16, 17},
                {16, 17, 18},
                {17, 18, 19},
                {20, 21, 22},
                {21, 22, 23},
                {22, 23, 24},
                {10, 16, 22},
                {5, 11, 17},
                {11, 17, 23},
                {0, 6, 12},
                {6, 12, 18},
                {12, 18, 24},
                {3, 8, 13},
                {8, 13, 18},
                {13, 18, 23},
                {4, 9, 14},
                {9, 14, 19},
                {14, 19, 24}
        };
        return combos;
    }
}
