package com.modulo24.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class URL {

    public static String decodeParam(String text) {
        try {
            return URLDecoder.decode(text, "UTF-8");
        }
        catch (UnsupportedEncodingException errDecoder) {
            return "";
        }
    }

    public static Date convertDate(String textDate, Date defaultValue) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setTimeZone(java.util.TimeZone.getTimeZone("GMT"));


        try {
            return simpleDateFormat.parse(textDate);
        }
        catch (ParseException errNumberFormat) {

            return defaultValue;
        }
    }

}
