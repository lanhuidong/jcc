package com.nexusy.jcc.reflect;

/**
 * @author lanhuidong
 * @since 2022-02-21
 */
@FunctionalInterface
public interface ClassHandler<T> {

    void handle(Class<?> clazz, T result);

}
