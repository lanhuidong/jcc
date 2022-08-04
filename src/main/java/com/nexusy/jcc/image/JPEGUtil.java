package com.nexusy.jcc.image;

/**
 * @author lanhuidong
 * @since 2022-08-04
 */
public final class JPEGUtil {

    /**
     * jpg头格式, SOF标识,0xFF
     */
    public static final byte IMAGE_START_VALUE = (byte) 0xFF;
    /**
     * jpg头格式, SOF第二个标识,0xC0
     */
    public static final byte IMAGE_SECOND_VALUE = (byte) 0xC0;
    public static final int IMAGE_WIDTH_HIGH_OFFSET = 7;
    public static final int IMAGE_WIDTH_LOW_OFFSET = 8;
    public static final int IMAGE_HEIGHT_HIGH_OFFSET = 5;
    public static final int IMAGE_HEIGHT_LOW_OFFSET = 6;

    private JPEGUtil() {
    }

    /**
     * 参考资料：<a href="https://blog.csdn.net/yangysng07/article/details/9025443?utm_medium=distribute.pc_relevant.none-task-blog-baidujs_baidulandingword-4&spm=1001.2101.3001.4242">...</a>
     */
    public static Meta getMeta(final byte[] data) {
        int width = 0;
        int height = 0;
        int size = data.length - IMAGE_HEIGHT_LOW_OFFSET;
        for (int p = 0; p < size; p++) {
            if (data[p] == IMAGE_START_VALUE && data[p + 1] == IMAGE_SECOND_VALUE) {
                width = ((data[p + IMAGE_WIDTH_HIGH_OFFSET] & 0xFF) << 8) | (data[p + IMAGE_WIDTH_LOW_OFFSET] & 0xFF);
                height = ((data[p + IMAGE_HEIGHT_HIGH_OFFSET] & 0xFF) << 8) | (data[p + IMAGE_HEIGHT_LOW_OFFSET] & 0xFF);
                break;
            }
        }
        return new Meta(width, height);
    }

}
