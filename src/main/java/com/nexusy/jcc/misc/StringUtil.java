package com.nexusy.jcc.misc;

/**
 * @author lanhuidong
 * @since 2022-02-24
 */
public final class StringUtil {

    private StringUtil() {
        throw new AssertionError();
    }

    public static <T> String join(CharSequence delimiter, T[] element) {
        StringBuilder sb = new StringBuilder();
        boolean firstElem = true;
        for (T number : element) {
            if (!firstElem) {
                sb.append(delimiter);
            } else {
                firstElem = false;
            }
            sb.append(number);
        }
        return sb.toString();
    }

    public static String join(CharSequence delimiter, int[] element) {
        StringBuilder sb = new StringBuilder();
        boolean firstElem = true;
        for (int number : element) {
            if (!firstElem) {
                sb.append(delimiter);
            } else {
                firstElem = false;
            }
            sb.append(number);
        }
        return sb.toString();
    }

    public static String join(CharSequence delimiter, long[] element) {
        StringBuilder sb = new StringBuilder();
        boolean firstElem = true;
        for (long number : element) {
            if (!firstElem) {
                sb.append(delimiter);
            } else {
                firstElem = false;
            }
            sb.append(number);
        }
        return sb.toString();
    }

    public static String join(CharSequence delimiter, float[] element) {
        StringBuilder sb = new StringBuilder();
        boolean firstElem = true;
        for (float number : element) {
            if (!firstElem) {
                sb.append(delimiter);
            } else {
                firstElem = false;
            }
            sb.append(number);
        }
        return sb.toString();
    }

    public static String join(CharSequence delimiter, double[] element) {
        StringBuilder sb = new StringBuilder();
        boolean firstElem = true;
        for (double number : element) {
            if (!firstElem) {
                sb.append(delimiter);
            } else {
                firstElem = false;
            }
            sb.append(number);
        }
        return sb.toString();
    }

}
