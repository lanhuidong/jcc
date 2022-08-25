package com.nexusy.jcc.misc;

/**
 * <pre>
 * 符号位
 * 不使用            时间戳（42位，可用138年）             机器码       序列号
 *     0 000000000000000000000000000000000000000000 0000 00000 000000000000
 * </pre>
 *
 * @author lanhuidong
 * @since 2022-08-25
 */
public final class SnowFlake {

    /**
     * 2022-08-30 00:00:00.000 GMT+0800
     */
    private static final long DEFAULT_EPOCH = 1661788800000L;

    private final long dataCenterId;
    private final long workerId;
    private long sequence;
    private final long epoch;
    private long lastTimestamp = -1L;
    private static final int DATA_CENTER_ID_BITS_NUM = 4;
    private static final int WORKER_ID_BITS_NUM = 5;
    private static final int SEQUENCE_BITS_NUM = 12;
    private static final long MAX_DATA_CENTER_ID = ~(-1L << DATA_CENTER_ID_BITS_NUM);
    private static final long MAX_WORKER_ID = ~(-1L << WORKER_ID_BITS_NUM);

    private static final long WORKER_ID_SHIFT = SEQUENCE_BITS_NUM;
    private static final long DATACENTER_ID_SHIFT = SEQUENCE_BITS_NUM + WORKER_ID_BITS_NUM;
    private static final long TIMESTAMP_SHIFT = SEQUENCE_BITS_NUM + WORKER_ID_BITS_NUM + DATA_CENTER_ID_BITS_NUM;
    private static final long SEQUENCE_MASK = ~(-1L << SEQUENCE_BITS_NUM);

    public SnowFlake() {
        this(0, 0, 0);
    }

    public SnowFlake(long epoch) {
        this(0, 0, epoch);
    }

    public SnowFlake(long dataCenterId, long workerId) {
        this(dataCenterId, workerId, 0);
    }

    public SnowFlake(long dataCenterId, long workerId, long epoch) {
        if (dataCenterId < 0 || dataCenterId > MAX_DATA_CENTER_ID) {
            throw new IllegalArgumentException("dataCenterId must between 0 and " + MAX_DATA_CENTER_ID);
        }
        if (workerId < 0 || workerId > MAX_WORKER_ID) {
            throw new IllegalArgumentException("workerId must between 0 and " + MAX_WORKER_ID);
        }
        if (epoch >= 0) {
            this.epoch = epoch;
        } else {
            this.epoch = DEFAULT_EPOCH;
        }
        this.dataCenterId = dataCenterId;
        this.workerId = workerId;
    }

    public synchronized long id() {
        long timestamp = System.currentTimeMillis();
        if (timestamp < lastTimestamp) {
            throw new IllegalStateException("current timestamp(" + timestamp + ") smaller than last timestamp(" + lastTimestamp + ")");
        }
        if (timestamp == lastTimestamp) {
            //sequence达到最大值(2^14-1=16383)之后如果+1，则sequence达到最大值变为0
            sequence = (sequence + 1) & SEQUENCE_MASK;
            //等待下一个时间戳
            if (sequence == 0) {
                timestamp = getNextMillisecond(lastTimestamp);
            }
        } else {
            //新的时间戳，序号重新开始计数
            sequence = 0L;
        }
        lastTimestamp = timestamp;
        //通过移位组装id值
        return ((timestamp - epoch) << TIMESTAMP_SHIFT)
            | (dataCenterId << DATACENTER_ID_SHIFT) | (workerId << WORKER_ID_SHIFT)
            | sequence;
    }

    private long getNextMillisecond(long lastTimestamp) {
        long timestamp = System.currentTimeMillis();
        while (timestamp <= lastTimestamp) {
            timestamp = System.currentTimeMillis();
        }
        return timestamp;
    }
}
