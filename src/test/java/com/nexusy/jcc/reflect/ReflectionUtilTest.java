package com.nexusy.jcc.reflect;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author lanhuidong
 * @since 2022-02-23
 */
@ChildAnnotation
public class ReflectionUtilTest {

    @Test
    void testIsAnnotationPresent() {
        Assertions.assertTrue(ReflectionUtil.isAnnotationPresent(ReflectionUtilTest.class, ParentAnnotation.class));
        Assertions.assertTrue(ReflectionUtil.isAnnotationPresent(ReflectionUtilTest.class, ChildAnnotation.class));
        Assertions.assertFalse(ReflectionUtil.isAnnotationPresent(ParentAnnotation.class, ChildAnnotation.class));
    }
}
