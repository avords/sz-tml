package com.parkdt.tml.utils;

/**
 * Created by Administrator on 2018/1/15.
 */
public class EncryptUtil {
    public static String encrypt(String pwd) throws Exception {
        String password = Encrypt.encryptSES(pwd, "cvz12bbn231hj13d");
        return password;
    }

    public static void main(String[] args) {
        try {
            System.out.println(EncryptUtil.encrypt("cc123456"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
