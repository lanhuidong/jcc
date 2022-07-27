package com.nexusy.jcc.misc;

/**
 * @author lanhuidong
 * @since 2022-02-18
 */
public class NumberUtil {

    /**
     * 该方法主要是为了处理Integer.MIN_VALUE=-Integer.MIN_VALUE的问题
     *
     * @param number 原数字
     * @return 返回非负数
     */
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
     */
    public static long toPositiveNumber(long number) {
        if (number == Long.MIN_VALUE) {
            return 0;
        } else if (number < 0) {
            return -number;
        } else {
            return number;
        }
    }

}
