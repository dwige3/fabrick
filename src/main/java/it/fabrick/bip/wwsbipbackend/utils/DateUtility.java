package it.fabrick.bip.wwsbipbackend.utils;

import org.apache.commons.lang3.time.FastDateFormat;

import java.text.ParseException;
import java.util.Date;


public abstract class DateUtility extends org.apache.commons.lang3.time.DateUtils {
    private static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd";

    public static Date dataFormat(String date) {
        return dateParser(date, DATE_FORMAT_PATTERN);
    }

    public static Date dateParser(String date, String pattern) {
        if (date == null || "".equals(date))
            return null;

        try {
            return FastDateFormat.getInstance(pattern).parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
