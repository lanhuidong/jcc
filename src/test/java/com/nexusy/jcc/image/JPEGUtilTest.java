package com.nexusy.jcc.image;

import com.nexusy.jcc.io.IOUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author lanhuidong
 * @since 2022-08-04
 */
public class JPEGUtilTest {

    @Test
    public void testGetMeta() {
        Meta meta = JPEGUtil.getMeta(IOUtil.getResourceAsBytes("golang.jpeg"));
        Assertions.assertEquals(600, meta.getWidth());
        Assertions.assertEquals(600, meta.getHeight());
    }
}
