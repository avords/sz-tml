// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 2018/1/22 13:27:38
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   Byte.java

package com.parkdt.tml.utils;


public class Byte
{

    public Byte()
    {
    }

    public static boolean Compare(byte input1[], byte input2[])
    {
        if(input1 == null || input2 == null)
            return false;
        if(input1.length != input2.length)
            return false;
        for(int i = 0; i < input1.length; i++)
            if(input1[i] != input2[i])
                return false;

        return true;
    }

    public static String byte2hex(byte buffer[])
    {
        String hs = "";
        String stmp = "";
        for(int n = 0; n < buffer.length; n++)
        {
            stmp = Integer.toHexString(buffer[n] & 0xff);
            if(stmp.length() == 1)
                hs = (new StringBuilder(String.valueOf(hs))).append("0").append(stmp).toString();
            else
                hs = (new StringBuilder(String.valueOf(hs))).append(stmp).toString();
        }

        return hs.toUpperCase();
    }

    public static byte[] hex2byte(byte buffer[])
    {
        if(buffer.length % 2 != 0)
            throw new IllegalArgumentException("\u957F\u5EA6\u4E0D\u662F\u5076\u6570");
        byte b2[] = new byte[buffer.length / 2];
        for(int n = 0; n < buffer.length; n += 2)
        {
            String item = new String(buffer, n, 2);
            b2[n / 2] = (byte)Integer.parseInt(item, 16);
        }

        return b2;
    }
}