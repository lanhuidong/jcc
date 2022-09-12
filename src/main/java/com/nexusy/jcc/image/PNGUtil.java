package com.nexusy.jcc.image;

/**
 * @author lanhuidong
 * @since 2022-08-04
 */
public class PNGUtil {

    private PNGUtil() {
        throw new AssertionError();
    }

    /**
     * 参考资料：<a href="https://blog.csdn.net/zzZZ20150101/article/details/121649412">...</a>
     *
     * @param data 图片二进制数据
     * @return 图片元数据
     */
    public static Meta getMeta(byte[] data) {
        int width = (((data[16] & 0xFF) << 24) + ((data[17] & 0xFF) << 16) + ((data[18] & 0xFF) << 8) + (data[19] & 0xFF));
        int height = (((data[20] & 0xFF) << 24) + ((data[21] & 0xFF) << 16) + ((data[22] & 0xFF) << 8) + (data[23] & 0xFF));
        return new Meta(width, height);
    }
}
