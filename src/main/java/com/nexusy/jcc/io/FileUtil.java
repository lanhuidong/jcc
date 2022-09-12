package com.nexusy.jcc.io;

import java.io.File;

/**
 * @author lanhuidong
 * @since 2022-03-23
 */
public final class FileUtil {

    private FileUtil() {
        throw new AssertionError();
    }

    public static boolean deleteDirs(String dirName) {
        return deleteDirs(new File(dirName));
    }

    public static boolean deleteDirs(File dir) {
        if (dir == null) {
            return false;
        }
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteDirs(file);
                } else {
                    if (!file.delete()) {
                        return false;
                    }
                }
            }
        }
        return dir.delete();
    }

}
