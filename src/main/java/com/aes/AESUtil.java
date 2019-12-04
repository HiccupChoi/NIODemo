package com.aes;


import java.io.File;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESUtil {
    /**
     * AES加密,返回BASE64编码后的加密字符串
     *
     * @param sSrc           -- 待加密内容
     * @param encodingFormat -- 字符串编码方式
     * @param algorithm      -- 使用的算法 算法/模式/补码方式, 目前支持ECB和CBC模式
     * @param sKey           -- 加密密钥
     * @param ivParameter    -- 偏移量,CBC模式时需要
     * @return Base64编码后的字符串
     */
    public static String encrypt(String sSrc, String encodingFormat, String algorithm, String sKey, String ivParameter) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithm);
        byte[] raw = sKey.getBytes(encodingFormat);
        SecretKeySpec sKeySpec = new SecretKeySpec(raw, "AES");

        IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes(encodingFormat));
        if (algorithm.contains("CBC")) {
            cipher.init(Cipher.ENCRYPT_MODE, sKeySpec, iv);
        } else {
            cipher.init(Cipher.ENCRYPT_MODE, sKeySpec);
        }
        byte[] encrypted = cipher.doFinal(sSrc.getBytes(encodingFormat));
        // BASE64 encode
        return Base64.getEncoder().encodeToString(encrypted);
    }

    /**
     * AES解密
     *
     * @param sSrc           -- 待解密Base64字符串
     * @param encodingFormat -- 字符串编码方式
     * @param algorithm      -- 使用的算法 算法/模式/补码方式, 目前支持ECB和CBC模式
     * @param sKey           -- 加密密钥
     * @param ivParameter    -- 偏移量,CBC模式时需要
     * @return 解密后的字符串
     */
    public static String decrypt(String sSrc, String encodingFormat, String algorithm, String sKey, String ivParameter) throws Exception {
        byte[] raw = sKey.getBytes(encodingFormat);
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance(algorithm);
        IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes(encodingFormat));
        if (algorithm.contains("CBC")) {
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
        } else {
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        }
        // BASE64 decode
        byte[] encrypted1 = Base64.getDecoder().decode(sSrc);
        byte[] original = cipher.doFinal(encrypted1);
        return new String(original, encodingFormat);
    }

    public static void main(String[] args) {
        try {
            String encrypt = AESUtil.encrypt("nkmvftdjarugjjdb", "UTF-8", "AES/CBC/PKCS5Padding", "businessinfo1119", "businessinfo1119");
            System.out.println("MyApplication---encrypt = " + encrypt);
            String decrypt = AESUtil.decrypt(encrypt, "UTF-8", "AES/CBC/PKCS5Padding", "businessinfo1119", "businessinfo1119");
            System.out.println("MyApplication---decrypt = " + decrypt);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}