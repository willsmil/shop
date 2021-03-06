package com.shop.Utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptUtil {
    public static String encode(String password){
        BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
        String hashPass = encode.encode(password);
        return hashPass;
    }
    public static boolean match(String bCryptPassword, String password1){
        BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
        return encode.matches(password1, bCryptPassword);
    }
}
