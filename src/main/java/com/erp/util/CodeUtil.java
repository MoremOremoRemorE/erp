package com.erp.util;

import java.util.Random;

/**
 * 生成随机字符串
 */
public class CodeUtil {
    private static final String[] CHARS = new String[] {"0","1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H",
            "J", "K", "L", "M", "N", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z" ,"a","b","c","d","e","f","g","h","i","g","k","l","m","n","o","p","q","r","s","t"
            ,"u","v","w","x","y","z"};

    private static final String[] INTS = new String[] {"1", "2", "3", "4", "5",
            "6", "7", "8", "9"};

    /**
     * 生成随机码
     * @param bit
     * @return
     */
    public static String generateRandomString(int bit){
        StringBuilder sb = new StringBuilder(20);
        Random r = new Random();
        for(int i=0; i<bit; i++){
            int num = r.nextInt(CHARS.length);
            sb.append(CHARS[num]);
        }
        return sb.toString();
    }

    public static String generateRandomNumber(int bit){
        StringBuilder sb = new StringBuilder(20);
        Random r = new Random();
        for(int i=0; i<bit; i++){
            int num = r.nextInt(INTS.length);
            sb.append(INTS[num]);
        }
        return sb.toString();
    }

    public static void main(String[] args){
        System.err.println(generateRandomNumber(1));
    }

}
