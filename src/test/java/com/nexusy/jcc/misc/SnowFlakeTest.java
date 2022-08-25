package com.nexusy.jcc.misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lanhuidong
 * @since 2022-08-25
 */
public class SnowFlakeTest {

    @Test
    void testDefaultConfig() {
        int count = 20000;
        SnowFlake snowFlake = new SnowFlake();
        Set<Long> ids = new HashSet<>(count);
        for (int i = 0; i < count; i++) {
            ids.add(snowFlake.id());
        }
        Assertions.assertEquals(count, ids.size());
    }

    @Test
    void testEpoch() {
        int count = 20000;
        SnowFlake snowFlake = new SnowFlake(0);
        Set<Long> ids = new HashSet<>(count);
        for (int i = 0; i < count; i++) {
            ids.add(snowFlake.id());
        }
        Assertions.assertEquals(count, ids.size());
    }

    @Test
    void testWorkerId() {
        SnowFlake snowFlake1 = new SnowFlake(0, 0, 0);
        SnowFlake snowFlake2 = new SnowFlake(0, 1, 0);
        int count = 20000;
        Set<Long> ids = new HashSet<>(count * 2);
        for (int i = 0; i < count; i++) {
            ids.add(snowFlake1.id());
            ids.add(snowFlake2.id());
        }
        Assertions.assertEquals(count * 2, ids.size());
    }

    enum Service {
        S1(17, 0), S2(0, 32);
        private final int dataCenterId;
        private final int workerId;

        Service(int dataCenterId, int workerId) {
            this.dataCenterId = dataCenterId;
            this.workerId = workerId;
        }
    }

    @ParameterizedTest
    @EnumSource(Service.class)
    void testWorkerIdTooMax(Service service) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SnowFlake(service.dataCenterId, service.workerId));
    }
}
