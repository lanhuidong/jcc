package com.nexusy.jcc.reflect;

import com.nexusy.jcc.rest.RestError;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lanhuidong
 * @since 2022-02-21
 */
public class ClassScannerTest {

    @Test
    void test() {
        Set<Class<?>> classes = new HashSet<>();
        ClassScanner.scan("com.nexusy.jcc", classes, (clazz, result) -> {
            if (RestError.class.isAssignableFrom(clazz) && RestError.class != clazz) {
                result.add(clazz);
            }
        });
        System.out.println(classes);
    }
}
