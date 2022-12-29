package com.thejoen.rabbit2.model.network;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Time {
    public static final int SEC = 60;
    public static final int MIN = 60;
    public static final int HOUR = 24;
    public static final int DAY = 30;
    public static final int MONTH = 12;

    public static String convertLocalDateTimeToTime(LocalDateTime localDateTime) {
        LocalDateTime now = LocalDateTime.now();

        long diffTime = localDateTime.until(now, ChronoUnit.SECONDS);

        String msg = null;
        if (diffTime < SEC){
            return diffTime + "초전";
        }
        diffTime = diffTime / SEC;
        if (diffTime < MIN) {
            return diffTime + "분 전";
        }
        diffTime = diffTime / MIN;
        if (diffTime < HOUR) {
            return diffTime + "시간 전";
        }
        diffTime = diffTime / HOUR;
        if (diffTime < DAY) {
            return diffTime + "일 전";
        }
        diffTime = diffTime / DAY;
        if (diffTime < MONTH) {
            return diffTime + "개월 전";
        }

        diffTime = diffTime / MONTH;
        return diffTime + "년 전";
    }

    public static String setTime(LocalDateTime time) {
        LocalDate now = LocalDate.now();
        if(now.isEqual(time.toLocalDate())) {
            return DateTimeFormatter.ofPattern("HH:mm").format(time);
        }else {
            if(now.getYear() == time.getYear()) {
                return time.format(DateTimeFormatter.ofPattern("M. d"));
            }else {
                return time.format(DateTimeFormatter.ofPattern("yy. M. d"));
            }
        }
    }
}

