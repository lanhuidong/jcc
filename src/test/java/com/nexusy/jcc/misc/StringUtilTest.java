package com.nexusy.jcc.misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author lanhuidong
 * @since 2022-02-24
 */
public class StringUtilTest {

    @Test
    void testJoin() {
        Assertions.assertEquals("1,2,3,4", StringUtil.join(",", new Integer[]{1, 2, 3, 4}));
        Assertions.assertEquals("1 2 3 4", StringUtil.join(" ", new Long[]{1L, 2L, 3L, 4L}));
        Assertions.assertEquals("A, B, C", StringUtil.join(", ", new String[]{"A", "B", "C"}));
        Assertions.assertEquals("2, 4, 8", StringUtil.join(", ", new int[]{2, 4, 8}));
        Assertions.assertEquals("11$22$55", StringUtil.join("$", new long[]{11L, 22L, 55L}));
        Assertions.assertEquals("1.1@2.2@7.7", StringUtil.join("@", new float[]{1.1F, 2.2F, 7.7F}));
        Assertions.assertEquals("0.1, 0.2, 0.3", StringUtil.join(", ", new double[]{0.1, 0.2, 0.3}));
    }
}
