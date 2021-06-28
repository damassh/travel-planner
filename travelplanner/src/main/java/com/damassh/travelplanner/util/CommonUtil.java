package com.damassh.travelplanner.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CommonUtil {

    public static final String UNIT = "UNITS";
    public static final String METRICS = "metrics";
    public static final String START_HOUR = "12:00";
    public static final String END_HOUR = "18:00";
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static boolean validateDateInterval(LocalDate date, LocalDate startDate, LocalDate endDate) {
        return date.isAfter(startDate.minusDays(1)) && date.isBefore(endDate.plusDays(1));
    }

    public static boolean validateTimeInterval(LocalDateTime date) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime startHour = LocalTime.parse(START_HOUR, format);
        LocalTime endHour = LocalTime.parse(END_HOUR, format);
        return date.getHour() >= startHour.getHour() && date.getHour() <= endHour.getHour();
    }
}
