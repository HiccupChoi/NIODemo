package com.crypt;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Random;

/**
 * @author Administrator
 */
public class Crypt {

    private Cipher enc;
    private Cipher dec;
    /**
     *
     */
    public static final String METHOD_AES = "AES/ECB/PKCS5Padding";

    public Crypt(byte[] pwd) {
        this(pwd, METHOD_AES);
    }

    /**
     * @param pwd
     * @param method
     */
    public Crypt(byte[] pwd, String method) {
        //     this.method = method;
        //    keyHex = Crypt.toHex(pwd);
        //     Log.i(TAG, "key="+keyHex);
        SecretKeySpec key = new SecretKeySpec(pwd, "AES");
        try {
            enc = Cipher.getInstance(method);
            dec = Cipher.getInstance(method);
            dec.init(Cipher.DECRYPT_MODE, key);
            enc.init(Cipher.ENCRYPT_MODE, key);
        } catch (Exception ex) {
        }
    }

    /**
     * 解密
     *
     * @param data 待解密内容
     * @return
     */
    public byte[] decrypt(byte[] data) {
        try {
            Cipher cipher = dec;
            synchronized (cipher) {
                return cipher.doFinal(data);
            }
        } catch (Throwable e) {
            //   Log.e(TAG, e);
        }
        return null;
    }

    public static void main(String[] args) {
        String base64 = "uSfDoELJ8LvZRfiaOCJrwcpPKbpT95TBhH5Huj6OaqeirR+uyAjAf70Q2E6HluHw";
        Crypt crypt = new Crypt("4&kplDezHjxUrMBF".getBytes());
        byte[] data = BASE64.decode(base64);
        if (data != null && data.length > 0) {
            byte[] serialData = crypt.decrypt(data);
            if (serialData != null) {
                System.out.println(new String(serialData));
            }
        }
    }

}
