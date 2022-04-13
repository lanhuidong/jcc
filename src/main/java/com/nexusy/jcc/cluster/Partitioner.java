package com.nexusy.jcc.cluster;

import com.nexusy.jcc.misc.NumberUtil;

/**
 * @author lanhuidong
 * @since 2022-04-13
 */
public final class Partitioner {

    private Partitioner() {
    }

    public static int partition(String key, int total) {
        if (total < 1) {
            throw new IllegalArgumentException("total must great than 0");
        }
        if (key == null) {
            return 0;
        }
        return NumberUtil.toPositiveNumber(key.hashCode()) % total;
    }

}
