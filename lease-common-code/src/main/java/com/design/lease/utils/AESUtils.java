package com.design.lease.utils;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class AESUtils {

    private static String src="Hello AES";

    public static Key getKey() throws NoSuchAlgorithmException {
        //生成key
        KeyGenerator keyGenerator=KeyGenerator.getInstance("AES");
        keyGenerator.init(new SecureRandom());
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] key1 = secretKey.getEncoded();

        //key转换为密钥
        Key key2 = new SecretKeySpec(key1, "AES");
        return key2;
    }

    public static String encodeHex(String message) {
        try {
            Key key = getKey();
            //加密
            Cipher cipher=Cipher.getInstance("AES/ECB/PKCS5padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] result = cipher.doFinal(message.getBytes());
            System.out.println("jdkAES加密: "+ Hex.encodeHex(result));  //转换为十六进制
            return String.valueOf(Hex.encodeHex(result));
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static String decodeHex(String message){
        try {
            byte[] verify = Hex.decodeHex(message.toCharArray());
            Cipher cipher=Cipher.getInstance("AES/ECB/PKCS5padding");
            cipher.init(Cipher.DECRYPT_MODE, getKey());
            byte[] bytes = cipher.doFinal(verify);
            System.out.println("jdkAES解密: "+new String(bytes));  //转换字符串
            return new String(bytes);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args){
//        try {
//            //生成key
//            KeyGenerator keyGenerator=KeyGenerator.getInstance("AES");
//            keyGenerator.init(new SecureRandom());
//            SecretKey secretKey = keyGenerator.generateKey();
//            byte[] key1 = secretKey.getEncoded();
//
//            //key转换为密钥
//            Key key2 = new SecretKeySpec(key1, "AES");
//
//            //加密
//            Cipher cipher=Cipher.getInstance("AES/ECB/PKCS5padding");
//            cipher.init(Cipher.ENCRYPT_MODE, key2);
//            byte[] result = cipher.doFinal(src.getBytes());
//            System.out.println("jdkAES加密: "+Hex.encodeHex(result));  //转换为十六进制
//
//            //解密
//            cipher.init(Cipher.DECRYPT_MODE, key2);
//            result = cipher.doFinal(result);
//            System.out.println("jdkAES解密: "+new String(result));  //转换字符串
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        System.out.println(AESUtils.encodeHex("1456"));
        System.out.println(AESUtils.decodeHex("13c713e99154366d87560178d1233a72"));
    }

}
