package com.dreamnight.test;

/**
 * Created by tianbenzhen on 2017/10/11.
 */
public class StringReverse {

    public static void main(String[] args) {
        String originalStr = "321gqwe";
        System.out.println(originalStr);
        System.out.println(reverse(originalStr).toString());
    }

    static String reverse(String original){
        if(original == null || original.trim().length() <= 0){
            return original;
        }
        char[] chars = original.toCharArray();
        int len = chars.length;
        for(int i=0; i<len/2; i++){
            char exchangec1 = chars[i];
            int exchangeindex = len-1-i;
            char exchangec2 = chars[exchangeindex];
            chars[i] = exchangec2;
            chars[exchangeindex] = exchangec1;
        }
        return String.valueOf(chars);
    }

}
