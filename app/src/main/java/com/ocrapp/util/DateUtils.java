package com.ocrapp.util;

import android.text.format.DateFormat;
import android.util.Log;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

//DateUtils Class For Diff Dates/time Convert
public class DateUtils {
    //variable declaration
    public static SimpleDateFormat[] dateFormats = null;
    private static final int defaultFormat = 2;
    private static final String TAG = "DateUtils";
    public static final String DATE_FORMAT_1 = "hh:mm a";
    public static final String DATE_FORMAT_2 = "h:mm a";
    public static final String DATE_FORMAT_3 = "yyyy-MM-dd";
    public static final String DATE_FORMAT_4 = "dd-MMMM-yyyy";
    public static final String DATE_FORMAT_5 = "dd MMMM yyyy";
    public static final String DATE_FORMAT_6 = "dd MMMM yyyy zzzz";
    public static final String DATE_FORMAT_7 = "EEE, MMM d, ''yy";
    public static final String DATE_FORMAT_8 = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_9 = "h:mm a dd MMMM yyyy";
    public static final String DATE_FORMAT_10 = "K:mm a, z";
    public static final String DATE_FORMAT_11 = "hh 'o''clock' a, zzzz";
    public static final String DATE_FORMAT_12 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String DATE_FORMAT_13 = "E, dd MMM yyyy HH:mm:ss z";
    public static final String DATE_FORMAT_14 = "yyyy.MM.dd G 'at' HH:mm:ss z";
    public static final String DATE_FORMAT_15 = "yyyyy.MMMMM.dd GGG hh:mm aaa";
    public static final String DATE_FORMAT_16 = "EEE, d MMM yyyy HH:mm:ss Z";
    public static final String DATE_FORMAT_17 = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    public static final String DATE_FORMAT_18 = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
    public static final String DATE_FORMAT_19 = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    //get current date method
    public static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }
    //get current time method
    public static String getCurrentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_1);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }
    public static String getDateTFomrat(String changeDate)
    {
        SimpleDateFormat inSDF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        SimpleDateFormat outSDF = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);

        String outDate = "";
        if (changeDate != null) {
            try {
                Date date = inSDF.parse(changeDate);
                outDate = outSDF.format(date);
            } catch (ParseException ex){
            }
        }
        return outDate;
    }
    /**
     * @param time        in milliseconds (Timestamp)
     * @param mDateFormat SimpleDateFormat
     */
    public static String getDateTimeFromTimeStamp(Long time, String mDateFormat) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(mDateFormat);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date dateTime = new Date(time);
        return dateFormat.format(dateTime);
    }

    /**
     * Get Timestamp from date and time
     *
     * @param mDateTime   datetime String
     * @param mDateFormat Date Format
     * @throws ParseException
     */
    public static long getTimeStampFromDateTime(String mDateTime, String mDateFormat)
            throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(mDateFormat);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = dateFormat.parse(mDateTime);
        return date.getTime();
    }

    /**
     * Return  datetime String from date object
     *
     * @param mDateFormat format of date
     * @param date        date object that you want to parse
     */
    public static String formatDateTimeFromDate(String mDateFormat, Date date) {
        if (date == null) {
            return null;
        }
        return DateFormat.format(mDateFormat, date).toString();
    }

    /**
     * Convert one date format string  to another date format string in android
     *
     * @param inputDateFormat  Input SimpleDateFormat
     * @param outputDateFormat Output SimpleDateFormat
     * @param inputDate        input Date String
     * @throws ParseException
     */
    public static String formatDateFromDateString(String inputDateFormat, String outputDateFormat,
                                                  String inputDate) throws ParseException {
        Date mParsedDate;
        //   String tempmOutputDateString="";
        String mOutputDateString = "";
        SimpleDateFormat mInputDateFormat =
                new SimpleDateFormat(inputDateFormat, Locale.getDefault());
        SimpleDateFormat mOutputDateFormat =
                new SimpleDateFormat(outputDateFormat, Locale.getDefault());
        try {
            mParsedDate = mInputDateFormat.parse(inputDate);
            mOutputDateString = mOutputDateFormat.format(mParsedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return mOutputDateString;

    }
    //convert time to am pm format
    public static String convert24TimeToAMPMFormat(String actualDate) {
       /* dateFormats = new SimpleDateFormat[possibleFormats.length];
        TimeZone gmtTZ = TimeZone.getTimeZone("GMT");

        for (int i = 0; i < possibleFormats.length; i++)
        {
            *//* TODO: Support other locales? *//*
            dateFormats[i] = new SimpleDateFormat(possibleFormats[i],
                    Locale.ENGLISH);

            dateFormats[i].setTimeZone(gmtTZ);
        }*/

    /*    if (actualDate == null || actualDate.equals("")) {
            return "";
        }*/
        int flagTime = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
        String outPutDate = "";
        Date date = null;
        for (String parse1 : possibleFormats) {
            SimpleDateFormat input = new SimpleDateFormat(parse1);
            try {
                if (flagTime == 0) {
                    date = input.parse(actualDate);
                    System.out.println("format Parse" + parse1);
                    // Log.e("Printing_Date " + date.toString());
                    Log.e("format_Parse", parse1);
                    flagTime = 1;
                }
                //break;
            } catch (ParseException e) {
                Log.e("Exceptionformat", parse1);
                System.out.println("ExceptioPrinting the value of " + parse1);
                flagTime = 0;
//                System.out.println("ExceptioPrinting Date " + date.toString());
            }
        }
        if (date != null) {
            outPutDate = sdf.format(date);
        }
        //   SimpleDateFormat input =  new SimpleDateFormat("HH:mm:ss");
        // SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
        //   String outPutDate = "";


        return outPutDate;
    }

    //possible formats array
    private static final String[] possibleFormats = {
            DATE_FORMAT_1, DATE_FORMAT_2, DATE_FORMAT_6,
            DATE_FORMAT_7, DATE_FORMAT_8,
            DATE_FORMAT_9, DATE_FORMAT_10,
            DATE_FORMAT_11, DATE_FORMAT_12,
            DATE_FORMAT_13, DATE_FORMAT_14,
            DATE_FORMAT_15, DATE_FORMAT_16,
            DATE_FORMAT_17, DATE_FORMAT_18, DATE_FORMAT_19
    };

    //private static final String TAG = "DateUtils";



   /* public DateUtils() { }

    static {
        final String[] possibleFormats1 = {
                "EEE, dd MMM yyyy HH:mm:ss z", // RFC_822
                "EEE, dd MMM yyyy HH:mm zzzz",
                "yyyy-MM-dd'T'HH:mm:ssZ",
                "yyyy-MM-dd'T'HH:mm:ss.SSSzzzz", // Blogger Atom feed has millisecs also
                "yyyy-MM-dd'T'HH:mm:sszzzz",
                "yyyy-MM-dd'T'HH:mm:ss z",
                "yyyy-MM-dd'T'HH:mm:ssz", // ISO_8601
                "yyyy-MM-dd'T'HH:mm:ss",
                "yyyy-MM-dd'T'HHmmss.SSSz",
                "yyyy-MM-dd"
        };

        dateFormats = new SimpleDateFormat[possibleFormats.length];
        TimeZone gmtTZ = TimeZone.getTimeZone("GMT");

        for (int i = 0; i < possibleFormats.length; i++)
        {
            *//* TODO: Support other locales? *//*
            dateFormats[i] = new SimpleDateFormat(possibleFormats[i],
                    Locale.ENGLISH);

            dateFormats[i].setTimeZone(gmtTZ);
        }
    }*/

    public static Date parseDate(String str) {
        Date result = null;
        str = str.trim();

        if (str.length() > 10) {
            // TODO deal with +4:00 (no zero before hour)
            if ((str.substring(str.length() - 5).indexOf("+") == 0 || str
                    .substring(str.length() - 5).indexOf("-") == 0)
                    && str.substring(str.length() - 5).indexOf(":") == 2) {

                String sign = str.substring(str.length() - 5,
                        str.length() - 4);

                str = str.substring(0, str.length() - 5) + sign + "0"
                        + str.substring(str.length() - 4);
                // logger.debug("CASE1 : new date " + strdate + " ? "
                //    + strdate.substring(0, strdate.length() - 5));

            }

            String dateEnd = str.substring(str.length() - 6);

            // try to deal with -05:00 or +02:00 at end of date
            // replace with -0500 or +0200
            if ((dateEnd.indexOf("-") == 0 || dateEnd.indexOf("+") == 0)
                    && dateEnd.indexOf(":") == 3) {
                // TODO deal with GMT-00:03
                if ("GMT".equals(str.substring(str.length() - 9, str
                        .length() - 6))) {
                    Log.d(TAG, "General time zone with offset, no change");
                } else {
                    // continue treatment
                    String oldDate = str;
                    String newEnd = dateEnd.substring(0, 3) + dateEnd.substring(4);
                    str = oldDate.substring(0, oldDate.length() - 6) + newEnd;
                    // logger.debug("!!modifying string ->"+strdate);
                }
            }
        }

        int i = 0;

        while (i < dateFormats.length) {
            try {
                result = dateFormats[i].parse(str);
                // logger.debug("******Parsing Success "+strdate+"->"+result+" with
                // "+dateFormats[i].toPattern());
                break;
            } catch (ParseException eA) {
                i++;
            }
        }

        return result;
    }

    /**
     * Format a date in a manner that would be most suitable for serialized
     * storage.
     *
     * @param date {@link Date} object to format.
     * @return Robust, formatted date string.
     */
    public static String formatDate(Date date) {
        return dateFormats[defaultFormat].format(date);
    }

    public static String getChangeDateSamePattern(String changeDate)
    {
        SimpleDateFormat inSDF = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat outSDF = new SimpleDateFormat("dd MMM yyyy",Locale.ENGLISH);

        String outDate = "";
        if (changeDate != null) {
            try {
                Date date = inSDF.parse(changeDate);
                outDate = outSDF.format(date);
            } catch (ParseException ex){
            }
        }
        return outDate;
    }

    public static String getConvertDateToString(Date actualDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
        //dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        //Date today = Calendar.getInstance().getTime();
        return dateFormat.format(actualDate);
    }
    public static String getChangeTimeFormat(String changeDate)
    {
        SimpleDateFormat inSDF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        SimpleDateFormat outSDF = new SimpleDateFormat("dd-MM-yyyy",Locale.ENGLISH);

        String outDate = "";
        if (changeDate != null) {
            try {
                Date date = inSDF.parse(changeDate);
                outDate = outSDF.format(date);
            } catch (ParseException ex){
            }
        }
        return outDate;

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
    public static Date getStringToDateFomratPRCard(String changeDate)
    {
        SimpleDateFormat inSDF = new SimpleDateFormat("dd MMM yy", Locale.ENGLISH);
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