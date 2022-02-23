package com.nexusy.jcc.reflect;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

/**
 * @author lanhuidong
 * @since 2022-02-23
 */
public final class ReflectionUtil {

    private ReflectionUtil() {
    }

    public static boolean isAnnotationPresent(Class<?> clazz, Class<? extends Annotation> annotation) {
        return isAnnotationPresent(clazz, annotation, null);
    }

    private static boolean isAnnotationPresent(Class<?> clazz, Class<? extends Annotation> annotation, Set<String> names) {
        //使用Set记录是为了防止无限递归导致栈溢出
        if (names == null) {
            names = new HashSet<>();
        }
        if (names.contains(clazz.getName())) {
            return false;
        }
        names.add(clazz.getName());
        if (clazz.isAnnotationPresent(annotation)) {
            return true;
        } else {
            for (Annotation clazzAnnotation : clazz.getAnnotations()) {
                return isAnnotationPresent(clazzAnnotation.annotationType(), annotation, names);
            }
        }
        return false;
    }
}
