package com.nexusy.jcc.image;

/**
 * @author lanhuidong
 * @since 2022-08-04
 */
public final class Meta {

    private final int width;
    private final int height;

    public Meta(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
