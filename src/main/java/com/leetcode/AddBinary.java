package com.leetcode;

/**
 * @Author: Hiccup
 * @Date: 2020/6/24 11:03
 */
public class AddBinary {

    public static void main(String[] args) {
        System.out.println(addBinaryCalc("11111","1"));
    }

    public static String addBinaryCalc(String a, String b) {
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();
    }

}
