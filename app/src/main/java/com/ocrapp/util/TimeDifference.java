package com.ocrapp.util;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TimeDifference {

    int years;
    int months;
    int days;
    int hours;
    int minutes;
    int seconds;
    String differenceString="";
    String timeName="left";
    public static String dateDuration(String inputDate, int day) {
        long date = System.currentTimeMillis();
        Log.e(" current date", String.valueOf(date));

        String str = "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        String dateString = sdf.format(date);

        String inputString2 = dateString;

        try {
            Date date1 = inputFormat.parse(inputDate);
            Date date2 = new Date(date);
            TimeDifference fg = new TimeDifference(date2, date1,"left",day);
            str = fg.getDifferenceString();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Log.d("date","difi "+str);
        return str;
    }
    public static String dateAgoDuration(String inputDate) {
       // timeName= "ago";
        long date = System.currentTimeMillis();

        String str = "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        String dateString = sdf.format(date);

        String inputString2 = dateString;

        try {
            Date date1 = inputFormat.parse(inputDate);
            Date date2 = new Date(date);
           TimeDifference fg = new TimeDifference(date2, date1,"ago",0);
            str = fg.getDifferenceString();

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }
    public static String getCurrentDate() {

        long date = System.currentTimeMillis();
        String str = "";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dateString = sdf.format(date);

        String inputString2 = dateString;

        return inputString2;
    }

    public TimeDifference(Date curdate, Date olddate, String timeName, int day) {

        long currentDate = curdate.getTime();
        long oldDate = olddate.getTime();



        float diff=currentDate - oldDate;
        if (diff >= 0) {
            int yearDiff = Math.round( ( diff/ (365l*2592000000f))>=1?( diff/ (365l*2592000000f)):0);
            if (yearDiff > 0) {
                years = yearDiff;
                String styledText = "<font color='#EB413C'>" + years + "</font>";
                setDifferenceString(years+ (years == 1 ? " year" : " years") + " "+timeName);
            } else {
                int monthDiff = Math.round((diff / 2592000000f)>=1?(diff / 2592000000f):0);
                if (monthDiff > 0) {
                    if (monthDiff > 11)
                        monthDiff = 11;

                    months = monthDiff;
                    String styledText = "<font color='#EB413C'>" + months + "</font>";
                    setDifferenceString(months+ (months == 1 ? " month" : " months") + " "+timeName);
                } else {
                    int dayDiff = Math.round((diff / (86400000f))>=1?(diff / (86400000f)):0);
                    if (dayDiff > 0) {
                        days = dayDiff;
                        if(days==30)
                            days=29;

                        setDifferenceString(days + (days == 1 ? " day" : " days") + " "+timeName);

                    }else {
                        int hourDiff = Math.round((diff / (3600000f))>=1?(diff / (3600000f)):0);
                        if (hourDiff > 0) {
                            hours = hourDiff;
                            String styledText = "<font color='#EB413C'>" + hours + "</font>";
                            //setDifferenceString( hours+ (hours == 1 ? " hour" : " hours") +" "+timeName);
                            setDifferenceString("Today");
                        } else {
                            int minuteDiff = Math.round((diff / (60000f))>=1?(diff / (60000f)):0);
                            if (minuteDiff > 0) {
                                minutes = minuteDiff;
                                String styledText = "<font color='#EB413C'>" + minutes + "</font>";
                              //  setDifferenceString(minutes + (minutes == 1 ? " minute" : " minutes") +" "+timeName);
                                setDifferenceString("Today");
                            } else {
                                int secondDiff = Math.round((diff / (1000f))>=1?(diff / (1000f)):0);
                                if (secondDiff > 0)
                                    seconds = secondDiff;
                                else
                                    seconds = 1;
                                String styledText = "<font color='#EB413C'>" + seconds + "</font>";
                               // setDifferenceString(seconds + (seconds == 1 ? " second" : " seconds") +" "+timeName);
                                setDifferenceString("Today");
                            }
                        }
                    }

                }
            }

        }else {
            setDifferenceString("");

        }

    }

    public String getDifferenceString() {
        return differenceString;
    }

    public void setDifferenceString(String differenceString) {
        this.differenceString = differenceString;
    }
    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

}
