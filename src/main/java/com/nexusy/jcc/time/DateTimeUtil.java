package com.nexusy.jcc.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @author lanhuidong
 * @since 2022-02-18
 */
public class DateTimeUtil {

    public static final DateTimeFormatter HTTP_GMT_FORMATTER = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);

    public static final DateTimeFormatter WFC_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static final DateTimeFormatter WFC_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String getHttpDate() {
        return LocalDateTime.now().format(HTTP_GMT_FORMATTER);
    }

    public static String now() {
        return LocalDateTime.now().format(WFC_DATE_TIME_FORMATTER);
    }

    public static String today() {
        return LocalDate.now().format(WFC_DATE_FORMATTER);
    }

}
