package com.nexusy.jcc.reflect;

import java.lang.annotation.*;

/**
 * @author lanhuidong
 * @since 2022-02-23
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ParentAnnotation {
}
