// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 2018/1/22 13:26:45
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   Des.java

package com.parkdt.tml.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

public class Des
{

    public Des()
    {
    }

    public static byte[] encrypt(byte src[], byte key[])
            throws Exception
    {
        SecureRandom sr = new SecureRandom();
        DESKeySpec dks = new DESKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        javax.crypto.SecretKey securekey = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(1, securekey, sr);
        return cipher.doFinal(src);
    }

    public static byte[] decrypt(byte src[], byte key[])
            throws Exception
    {
        SecureRandom sr = new SecureRandom();
        DESKeySpec dks = new DESKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        javax.crypto.SecretKey securekey = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(2, securekey, sr);
        return cipher.doFinal(src);
    }
}