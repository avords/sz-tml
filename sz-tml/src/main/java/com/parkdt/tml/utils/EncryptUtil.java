package com.parkdt.tml.utils;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

/**
 * Created by Administrator on 2018/1/15.
 */
public class EncryptUtil {
    public static String encrypt(String pwd) throws Exception {
        //确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newstr = base64en.encode(md5.digest(pwd.getBytes("utf-8")));
        return newstr;
    }

    public static void main(String[] args) {
        try {
            System.out.println(EncryptUtil.encrypt("123456"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
