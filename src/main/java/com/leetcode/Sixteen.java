package com.leetcode;

import java.util.HashMap;

/**
 * @Author: Hiccup
 * @Date: 2019/8/26 5:46 PM
 * LeetCode - 36 判断一个数独是否有效
 */
public class Sixteen {

    public static void main(String[] args) {

    }

    public boolean isValidSudoku(char[][] board) {

        // 判断一共九行是否存在重复数
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        // 判断一共九列是否存在重复数
        HashMap<Integer, Integer> [] columns = new HashMap[9];
        // 判断一共九个小的3X3分区是否存在重复数
        HashMap<Integer, Integer> [] boxes = new HashMap[9];
        // 初始化hashMap
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        // validate a board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int)num;
                    int box_index = (i / 3 ) * 3 + j / 3;

                    // keep the current cell value
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    // check if this value has been already seen before
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1){
                        return false;
                    }
                }
            }
        }

        return true;
    }

}
