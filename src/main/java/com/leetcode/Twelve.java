package com.leetcode;

/**
 * @Author: Hiccup
 * @Date: 2019/8/22 5:10 PM
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 */
public class Twelve {

    public static void main(String[] args) {
        System.out.println(strStr("xl", "xl"));
    }

    private static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

}
