package com.test;

import java.io.File;

/**
 * @Author: Hiccup
 * @Date: 2019/11/13 4:08 下午
 */
public class FileLiset {

    public static void main(String[] args) {
        File[] root = File.listRoots();
        for(int i=0; i < root.length; i++)
            System.out.println(root[i]);
    }

}
