package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author: Hiccup
 * @Date: 2019/8/20 20:47
 * 判断有效括号
 */
public class Eight {

    public static void main(String[] args) {
        String s = "{([])}";
        System.out.println(isValid(s));
    }

    private static boolean isValid(String s) {
        HashMap<Byte, Byte> hashMap = new HashMap<>();
        hashMap.put((byte) ')', (byte) '(');
        hashMap.put((byte) ']', (byte) '[');
        hashMap.put((byte) '}', (byte) '{');

        ArrayList<Byte> arrayList = new ArrayList<>();
        byte[] bytes = s.getBytes();
        if (bytes.length % 2 != 0){
            return false;
        }
        byte frontValue;
        for (byte aByte : bytes) {
            switch (aByte) {
                case '(':
                case '[':
                case '{':
                    arrayList.add(aByte);
                    if (arrayList.size() > bytes.length / 2){
                        return false;
                    }
                    break;
                case ')':
                case ']':
                case '}':
                    if (arrayList.isEmpty()) {
                        return false;
                    }
                    frontValue = arrayList.get(arrayList.size() - 1);
                    if (frontValue == hashMap.get(aByte)) {
                        arrayList.remove(arrayList.size() - 1);
                    } else {
                        return false;
                    }
                    break;
                default:
                    break;
            }

        }
        return arrayList.isEmpty();
    }

}
