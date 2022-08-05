package com.nexusy.jcc.image;

import com.nexusy.jcc.io.IOUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author lanhuidong
 * @since 2022-08-04
 */
public class PNGUtilTest {

    @Test
    void testGetMeta() {
        Meta meta = PNGUtil.getMeta(IOUtil.getResourceAsBytes("vim-go.png"));
        Assertions.assertEquals(320, meta.getWidth());
        Assertions.assertEquals(272, meta.getHeight());
        Meta meta2 = PNGUtil.getMeta(IOUtil.getResourceAsBytes("test.png"));
        Assertions.assertEquals(1176, meta2.getWidth());
        Assertions.assertEquals(266, meta2.getHeight());
    }
}
