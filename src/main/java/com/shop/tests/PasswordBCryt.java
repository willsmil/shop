package com.shop.tests;

import com.shop.Utils.BCryptUtil;
import com.shop.Utils.Cos;

import java.io.File;
import java.net.URL;

public class PasswordBCryt {
    public static void getPass(String[] args){
        String password = "admin";
        password = BCryptUtil.encode(password);
        System.out.println(password);
    }

    public static void main(String[] args) {
        String fileStr = "D:/code/java/resource/store.jpg";
        String url = Cos.upload("images/",fileStr);
        System.out.println(url);
    }
}
