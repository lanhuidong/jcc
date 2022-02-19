package com.nexusy.jcc.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lanhuidong
 * @since 2022-02-19
 */
public class NamedThreadFactory implements ThreadFactory {

    private static final Map<String, AtomicInteger> SEQ_MAP = new ConcurrentHashMap<>();

    private final String prefix;

    public NamedThreadFactory(String prefix) {
        if (prefix == null || prefix.trim().length() == 0) {
            throw new IllegalArgumentException("Thread name prefix must not be blank.");
        }
        this.prefix = prefix + "-";
        SEQ_MAP.putIfAbsent(this.prefix, new AtomicInteger());
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setName(prefix + SEQ_MAP.get(prefix).getAndIncrement());
        return t;
    }

}
