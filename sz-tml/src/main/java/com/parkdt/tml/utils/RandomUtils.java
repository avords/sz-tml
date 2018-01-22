package com.parkdt.tml.utils;

import java.util.Random;

/**
 * Created by Administrator on 2018/1/22.
 */
public class RandomUtils {
    public static String getValidateCode(){
        Random random = new Random();
        int i = random.nextInt(9000)+1000;
        return String.valueOf(i);
    }

    public static void main(String[] args) {
        System.out.println(getValidateCode());
    }
}
