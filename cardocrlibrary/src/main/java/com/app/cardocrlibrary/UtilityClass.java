package com.app.cardocrlibrary;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class UtilityClass {
    public static Boolean isValidFormat1(String changeDate) {
        SimpleDateFormat inSDF = new SimpleDateFormat("yyyy/MM/dd");
        // SimpleDateFormat outSDF = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        // String outDate = "";
        if (changeDate != null) {
            try {
                Date date = inSDF.parse(changeDate);
                // outDate = outSDF.format(date);
            } catch (ParseException ex) {
                return false;
            }
        }
        return true;
    }
    public static Date getStringToDateFomrat1(String changeDate)
    {
        SimpleDateFormat inSDF = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH);
        // SimpleDateFormat outSDF = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);

        String outDate = "";
        Date date=null;
        if (changeDate != null) {
            try {
                date = inSDF.parse(changeDate);
                //  outDate = outSDF.format(date);
            } catch (ParseException ex){
            }
        }
        return date;
    }
    public static Boolean isValidFormat2(String changeDate) {
        SimpleDateFormat inSDF = new SimpleDateFormat("yyyy-MM-dd");
        // SimpleDateFormat outSDF = new SimpleDateFormat("yyyy/MM/dd",Locale.ENGLISH);

        // String outDate = "";
        if (changeDate != null) {
            try {
                Date date = inSDF.parse(changeDate);
                // outDate = outSDF.format(date);
            } catch (ParseException ex) {
                return false;
            }
        }
        return true;
    }
    public static Date getStringToDateFomrat2(String changeDate)
    {
        SimpleDateFormat inSDF = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        // SimpleDateFormat outSDF = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);

        String outDate = "";
        Date date=null;
        if (changeDate != null) {
            try {
                date = inSDF.parse(changeDate);
                //  outDate = outSDF.format(date);
            } catch (ParseException ex){
            }
        }
        return date;
    }
}
