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
        Assertions.assertTrue(NumberUtil.toNonNegative(Integer.MIN_VALUE) >= 0);
        Assertions.assertTrue(NumberUtil.toNonNegative(Integer.MAX_VALUE) >= 0);
        Assertions.assertTrue(NumberUtil.toNonNegative(0) >= 0);
        Assertions.assertTrue(NumberUtil.toNonNegative(1024) >= 0);
        Assertions.assertTrue(NumberUtil.toNonNegative(-1024) >= 0);

        Assertions.assertTrue(NumberUtil.toNonNegative(Long.MIN_VALUE) >= 0);
        Assertions.assertTrue(NumberUtil.toNonNegative(Long.MAX_VALUE) >= 0);
        Assertions.assertTrue(NumberUtil.toNonNegative(0L) >= 0);
        Assertions.assertTrue(NumberUtil.toNonNegative(102400000000L) >= 0);
        Assertions.assertTrue(NumberUtil.toNonNegative(-102400000000L) >= 0);
    }
}
