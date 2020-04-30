package com.crypt;

public class BASE64 {


    public static byte[] decode(String base64) {
        if (base64 == null || base64.isEmpty()) {
            return null;
        }
        return decode(base64, 0, base64.length());
    }

    /**
     * @param base64
     * @return
     */
    public static byte[] decode(String base64, int off, int len) {
        //	Log.d("BASE64", "base64=%s", base64);
        if (base64 == null || base64.isEmpty()) {
            return null;
        }
        // how many padding digits?
        int pad = 0;
        int end = off + len;
        for (int i = end - 1; base64.charAt(i) == '='; i--) {
            pad++;
        }
        int l = len;
        // we know know the lenght of the target byte array.
        int length = l * 3 / 4 - pad;
        byte[] raw = new byte[length];
        int rawIndex = 0;
        // loop through the base64 value.  A correctly formed
        // base64 string always has a multiple of 4 characters.
        int mend = end - 3;
        for (int i = off; i < mend; i += 4) {
            int block = (getValue(base64.charAt(i)) << 18)
                    + (getValue(base64.charAt(i + 1)) << 12)
                    + (getValue(base64.charAt(i + 2)) << 6)
                    + (getValue(base64.charAt(i + 3)));
            // based on the block, the byte array is filled with the
            // appropriate 8 bit values
            for (int j = 0; j < 3 && rawIndex + j < raw.length; j++) {
                raw[rawIndex + j] = (byte) ((block >> (8 * (2 - j))) & 0xff);
            }
            rawIndex += 3;
        }
        return raw;
    }

    /*
     * getValue
     *
     * translates from base64 digits to their 6 bit value
     */
    private static int getValue(char c) {
        return c > 64 && c < 91
                ? c - 65
                : c > 96 && c < 123
                ? c - 71
                : c > 47 && c < 58
                ? c + 4
                : c == 43
                ? 62
                : c == 47
                ? 63
                : 0;
    }

}
