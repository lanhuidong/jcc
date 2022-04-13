package com.nexusy.jcc.cluster;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author lanhuidong
 * @since 2022-04-13
 */
public class PartitionerTest {

    @Test
    void testNullKey() {
        int partitionNo = Partitioner.partition(null, 1);
        Assertions.assertEquals(0, partitionNo);
    }

    @Test
    void test() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> Partitioner.partition(null, 0));
    }

    @Test
    void testPartition() {
        int total = 5;
        int partitionNo = Partitioner.partition("partition", total);
        Assertions.assertTrue(partitionNo > -1);
        Assertions.assertTrue(partitionNo < total);
    }
}
