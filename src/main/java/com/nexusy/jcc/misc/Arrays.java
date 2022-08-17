package com.nexusy.jcc.misc;

/**
 * @author lanhuidong
 * @since 2022-04-07
 */
public final class Arrays {

    public static final byte[] EMPTY_BYTES = {};
    public static final int[] EMPTY_INTS = {};
    public static final long[] EMPTY_LONGS = {};
    public static final float[] EMPTY_FLOATS = {};
    public static final double[] EMPTY_DOUBLES = {};
    public static final char[] EMPTY_CHARS = {};
    public static final Object[] EMPTY_OBJECTS = {};
    public static final String[] EMPTY_STRINGS = {};

    private Arrays() {
    }

    public static int[] ofInts(int... elements) {
        if (elements.length != 0) {
            return elements.clone();
        } else {
            return EMPTY_INTS;
        }
    }

    public static long[] ofLongs(long... elements) {
        if (elements.length != 0) {
            return elements.clone();
        } else {
            return EMPTY_LONGS;
        }
    }

    public static float[] ofFloats(float... elements) {
        if (elements.length != 0) {
            return elements.clone();
        } else {
            return EMPTY_FLOATS;
        }
    }

    public static double[] ofDoubles(double... elements) {
        if (elements.length != 0) {
            return elements.clone();
        } else {
            return EMPTY_DOUBLES;
        }
    }

    @SafeVarargs
    public static <T> T[] of(T... elements) {
        return elements.clone();
    }

}
