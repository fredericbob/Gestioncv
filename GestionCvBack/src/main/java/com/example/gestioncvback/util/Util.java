package com.example.gestioncvback.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Util {

    public static Date parseToDate(String str_date) throws ParseException {
        if (str_date == null || str_date.equals("")) return  null;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return new Date(sdf.parse(str_date).getTime());
    }
}
