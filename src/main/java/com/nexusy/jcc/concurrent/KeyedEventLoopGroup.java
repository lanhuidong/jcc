package com.nexusy.jcc.concurrent;

import com.nexusy.jcc.misc.NumberUtil;

import java.util.concurrent.Future;

/**
 * @author lanhuidong
 * @since 2022-03-18
 */
public class KeyedEventLoopGroup implements AutoCloseable {

    private final EventLoop[] loops;
    private final int loopNum;

    public KeyedEventLoopGroup() {
        loopNum = Runtime.getRuntime().availableProcessors();
        loops = new EventLoop[loopNum];
        for (int i = 0; i < loopNum; i++) {
            EventLoop loop = new EventLoop();
            loops[i] = loop;
        }
    }

    public Future<?> submit(String key, Runnable task) {
        int index = NumberUtil.toNonNegative(key.hashCode()) % loopNum;
        return loops[index].submit(task);
    }

    @Override
    public void close() throws Exception {
        for (EventLoop loop : loops) {
            loop.close();
        }
    }

}
