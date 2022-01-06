package com.chen.seckill.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component
public class MD5Utils {
    public static String md5(String src){
        return DigestUtils.md5Hex(src);
    }
    private static final String salt="1a2b3c4d";

    public static String inputPasstoFromPass(String inputPass){
        String str =salt.charAt(0)+salt.charAt(2)+inputPass+salt.charAt(5)+salt.charAt(4);
        return  md5(str);
    }
    public static String fromPassToDBPass(String formPass,String salt){
        String str =salt.charAt(0)+salt.charAt(2)+formPass+salt.charAt(5)+salt.charAt(4);
        return  md5(salt);
    }
    public static String inputPasstoDBPass(String inputPass,String salt){
        String fromPass = inputPasstoFromPass(inputPass);
        String dbPass = fromPassToDBPass(fromPass, salt);
        return dbPass;
    }

    public static void main(String[] args) {
        System.out.println(inputPasstoFromPass("12346"));
    }
}
