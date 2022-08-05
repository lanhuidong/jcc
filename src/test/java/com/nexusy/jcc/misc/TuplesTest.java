package com.nexusy.jcc.misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author lanhuidong
 * @since 2022-08-05
 */
public class TuplesTest {

    @Test
    void testTuple1() {
        Tuples.Tuple1<String> tuple = Tuples.of("tuple");
        Assertions.assertEquals("tuple", tuple.f1);
    }

    @Test
    void testTuple2() {
        Tuples.Tuple2<String, Integer> tuple = Tuples.of("tuple", 777);
        Assertions.assertEquals("tuple", tuple.f1);
        Assertions.assertEquals(777, tuple.f2);
    }

    @Test
    void testTuple3() {
        Tuples.Tuple3<String, Integer, Double> tuple = Tuples.of("tuple", 777, 100d);
        Assertions.assertEquals("tuple", tuple.f1);
        Assertions.assertEquals(777, tuple.f2);
        Assertions.assertEquals(100d, tuple.f3);
    }

    @Test
    void testTuple4() {
        Tuples.Tuple4<String, Integer, Double, Boolean> tuple = Tuples.of("tuple", 777, 100d, true);
        Assertions.assertEquals("tuple", tuple.f1);
        Assertions.assertEquals(777, tuple.f2);
        Assertions.assertEquals(100d, tuple.f3);
        Assertions.assertTrue(tuple.f4);
    }

    @Test
    void testTuple5() {
        Tuples.Tuple5<String, Integer, Double, Boolean, Character> tuple = Tuples.of("tuple", 777, 100d, true, 'c');
        Assertions.assertEquals("tuple", tuple.f1);
        Assertions.assertEquals(777, tuple.f2);
        Assertions.assertEquals(100d, tuple.f3);
        Assertions.assertTrue(tuple.f4);
        Assertions.assertEquals('c', tuple.f5);
    }

}
