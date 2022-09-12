package com.nexusy.jcc.misc;

/**
 * @author lanhuidong
 * @since 2022-02-18
 */
public final class NumberUtil {

    private NumberUtil() {
        throw new AssertionError();
    }

    /**
     * 该方法主要是为了处理Integer.MIN_VALUE=-Integer.MIN_VALUE的问题
     *
     * @param number 原数字
     * @return 返回非负数
     * @see #toNonNegative(int)
     */
    @Deprecated
    public static int toPositiveNumber(int number) {
        if (number == Integer.MIN_VALUE) {
            return 0;
        } else if (number < 0) {
            return -number;
        } else {
            return number;
        }
    }

    /**
     * 该方法主要是为了处理Long.MIN_VALUE=-Long.MIN_VALUE的问题
     *
     * @param number 原数字
     * @return 返回非负数
     * @see #toNonNegative(long)
     */
    @Deprecated
    public static long toPositiveNumber(long number) {
        if (number == Long.MIN_VALUE) {
            return 0;
        } else if (number < 0) {
            return -number;
        } else {
            return number;
        }
    }

    /**
     * 该方法主要是为了处理Integer.MIN_VALUE=-Integer.MIN_VALUE的问题
     *
     * @param number 原数字
     * @return 返回非负数
     */
    public static int toNonNegative(int number) {
        return number & Integer.MAX_VALUE;
    }

    /**
     * 该方法主要是为了处理Long.MIN_VALUE=-Long.MIN_VALUE的问题
     *
     * @param number 原数字
     * @return 返回非负数
     */
    public static long toNonNegative(long number) {
        return number & Long.MAX_VALUE;
    }

}
