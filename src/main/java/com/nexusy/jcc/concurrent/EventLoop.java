package com.nexusy.jcc.concurrent;

import java.util.concurrent.*;

/**
 * @author lanhuidong
 * @since 2022-03-18
 */
public class EventLoop implements AutoCloseable {

    private final ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("event-loop"), new ThreadPoolExecutor.CallerRunsPolicy());

    public Future<?> submit(Runnable task) {
        return executor.submit(task);
    }

    @Override
    public void close() throws Exception {
        executor.shutdown();
        if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
            executor.shutdownNow();
        }
    }
}
