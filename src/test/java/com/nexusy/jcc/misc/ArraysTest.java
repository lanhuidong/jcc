package com.nexusy.jcc.misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author lanhuidong
 * @since 2022-08-17
 */
public class ArraysTest {

    @Test
    void testIntArray() {
        int[] array = Arrays.ofInts(1, 2, 3, 4, 5);
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
        Assertions.assertArrayEquals(new int[]{}, Arrays.ofInts());
    }

    @Test
    void testLongArray() {
        long[] array = Arrays.ofLongs(1, 2, 3, 4, 5);
        Assertions.assertArrayEquals(new long[]{1, 2, 3, 4, 5}, array);
        Assertions.assertArrayEquals(new long[]{}, Arrays.ofLongs());
    }

    @Test
    void testFloatArray() {
        float[] array = Arrays.ofFloats(1, 2, 3, 4, 5);
        Assertions.assertArrayEquals(new float[]{1, 2, 3, 4, 5}, array);
        Assertions.assertArrayEquals(new float[]{}, Arrays.ofFloats());
    }

    @Test
    void testDoubleArray() {
        double[] array = Arrays.ofDoubles(1, 2, 3, 4, 5);
        Assertions.assertArrayEquals(new double[]{1, 2, 3, 4, 5}, array);
        Assertions.assertArrayEquals(new double[]{}, Arrays.ofDoubles());
    }

    @Test
    void testGenericArray() {
        String[] array = Arrays.of("a", "b", "c");
        Assertions.assertArrayEquals(new String[]{"a", "b", "c"}, array);
        Assertions.assertArrayEquals(new Object[]{}, Arrays.of());
    }

}
