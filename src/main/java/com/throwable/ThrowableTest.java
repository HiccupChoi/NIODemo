package com.throwable;

/**
 * @Author: Hiccup
 * @Date: 2019/12/12 11:04
 */
public class ThrowableTest {

    public static void main(String[] args) {
        while (true){
            try {
                text();
            } catch (Throwable throwable){
                break;
            }
        }
        System.out.println("break");
    }

    private static void text() {
        throw new IllegalStateException("hermes read data length is 0.");
    }


}
