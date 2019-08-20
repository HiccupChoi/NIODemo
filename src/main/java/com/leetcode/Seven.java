package com.leetcode;

/**
 * @Author: Hiccup
 * @Date: 2019/8/20 5:56 PM
 * 获取最大公共前缀
 */
public class Seven {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

    private static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length() - 1);
            }
            if (prefix.isEmpty()){
                return "";
            }
        }
        return prefix;
    }

}
