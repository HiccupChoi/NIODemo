package com.nio.path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Author: Hiccup
 * @Date: 2020/6/9 14:30
 */
public class PathTest {

    public static void main(String[] args) throws IOException {
        Path listing = Paths.get("./").toRealPath();

        System.out.println(listing.getFileName());
//        System.out.println(listing.getNameCount());
//        System.out.println(listing.getParent());
//        System.out.println(listing.getRoot());
//        System.out.println(listing.subpath(0, 1));

        System.out.println(Files.readAttributes(listing,"*"));
    }

}
