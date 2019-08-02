package com.example.network.utils;

public class StringUtils {
    public static String defaultStr(String in,String defaultStr){
        return in == null || in.isEmpty() || in.trim().isEmpty() ? defaultStr : in;
    }
}
