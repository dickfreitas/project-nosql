package com.projectnosql.projectnosql.resource.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {
    public static String decodeUrl(String text){
        try {
            return URLDecoder.decode(text , "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}
