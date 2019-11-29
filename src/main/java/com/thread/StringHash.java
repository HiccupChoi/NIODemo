package com.thread;


/**
 * @Author: Hiccup
 * @Date: 2019/10/28 4:52 下午
 */
public class StringHash {

    private static String[] allChars = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
                                        "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
                                        "0","1", "2", "3", "4", "5", "6", "7", "8", "9",
                                        "+", "-", "*", "/"};

    private static final int CHAR_LENGTH = 65;

    public static void main(String[] args) {
        for (int i = 0; i < CHAR_LENGTH; i = i + 8) {
            final int j = i;
            Runnable runnable = () -> checkPassword(j, Math.min((j + 7), CHAR_LENGTH));
            new Thread(runnable).start();
        }
    }

    private static void checkPassword(int before, int length){
        StringBuilder x;
        for (int i = before; i < length; i++) {
            x = new StringBuilder(allChars[i]);
            for (int j = before; j < length; j++) {
                StringBuilder y = new StringBuilder(x);
                y.append(allChars[j]);
                for (int k = 0; k < CHAR_LENGTH; k++) {
                    StringBuilder z = new StringBuilder(y);
                    z.append(allChars[k]);
                    for (int l = 0; l < CHAR_LENGTH; l++) {
                        StringBuilder a = new StringBuilder(z);
                        a.append(allChars[l]);
                        for (int m = 0; m < CHAR_LENGTH; m++) {
                            StringBuilder b = new StringBuilder(a);
                            b.append(allChars[m]);
                            for (int n = 0; n < CHAR_LENGTH; n++) {
                                StringBuilder c = new StringBuilder(b);
                                c.append(allChars[n]);
                                if (c.toString().hashCode() == 1427398894 || c.toString().hashCode() == -846608593){
                                    System.out.println(c + "    hashcode = " + c.toString().hashCode());
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
