package com.nexusy.jcc.time;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author lanhuidong
 * @since 2022-02-18
 */
public class DateTimeUtilTest {

    @Test
    void testHttpDate() {
        String httpDate = DateTimeUtil.getHttpDate();
        Assertions.assertTrue(httpDate.endsWith("GMT"));
        Assertions.assertEquals(29, httpDate.length());
    }

    @Test
    void testNow() {
        String now = DateTimeUtil.now();
        Assertions.assertEquals(19, now.length());
    }

    @Test
    void testToday() {
        String today = DateTimeUtil.today();
        Assertions.assertEquals(10, today.length());
    }

}
