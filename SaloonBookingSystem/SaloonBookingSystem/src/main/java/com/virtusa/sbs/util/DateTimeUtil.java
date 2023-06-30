package com.virtusa.sbs.util;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String TIME_FORMAT = "HH:mm:ss";
    private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private DateTimeUtil(){
    	//constructor
    }
    public static String formatDate(LocalDateTime date) {
        return date.format(DateTimeFormatter.ofPattern(DATE_FORMAT));
    }

    public static String formatTime(LocalDateTime time) {
        return time.format(DateTimeFormatter.ofPattern(TIME_FORMAT));
    }

    public static String formatDateTime(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern(DATETIME_FORMAT));
    }

    public static LocalDateTime parseDate(String dateStr) {
        return LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern(DATE_FORMAT));
    }

    public static LocalDateTime parseTime(String timeStr) {
        return LocalDateTime.parse(timeStr, DateTimeFormatter.ofPattern(TIME_FORMAT));
    }

    public static LocalDateTime parseDateTime(String dateTimeStr) {
        return LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern(DATETIME_FORMAT));
    }

    public static Time convertToSqlTime(LocalTime appointmentTime) {
        if (appointmentTime == null) {
            return null;
        }
        return Time.valueOf(appointmentTime);
    }
    
    public static Date convertToSqlDate(LocalDate appointmentDate) {
        if (appointmentDate == null) {
            return null;
        }
        return Date.valueOf(appointmentDate);
    }

    public static LocalDate convertToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalTime convertToLocalTime(Time time) {
        return time.toLocalTime();
    }


	
}

