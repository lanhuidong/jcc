package com.nexusy.jcc.misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author lanhuidong
 * @since 2022-02-18
 */
public class NumberUtilTest {

    @Test
    void test() {
        Assertions.assertTrue(NumberUtil.toPositiveNumber(Integer.MIN_VALUE) >= 0);
        Assertions.assertTrue(NumberUtil.toPositiveNumber(Integer.MAX_VALUE) >= 0);
        Assertions.assertTrue(NumberUtil.toPositiveNumber(0) >= 0);
        Assertions.assertTrue(NumberUtil.toPositiveNumber(1024) >= 0);
        Assertions.assertTrue(NumberUtil.toPositiveNumber(-1024) >= 0);

        Assertions.assertTrue(NumberUtil.toPositiveNumber(Long.MIN_VALUE) >= 0);
        Assertions.assertTrue(NumberUtil.toPositiveNumber(Long.MAX_VALUE) >= 0);
        Assertions.assertTrue(NumberUtil.toPositiveNumber(0L) >= 0);
        Assertions.assertTrue(NumberUtil.toPositiveNumber(102400000000L) >= 0);
        Assertions.assertTrue(NumberUtil.toPositiveNumber(-102400000000L) >= 0);
    }
}
