package com.nexusy.jcc.io;

import java.io.File;

/**
 * @author lanhuidong
 * @since 2022-03-23
 */
public final class FileUtil {

    private FileUtil() {
    }

    public static boolean deleteDirs(String dirName) {
        return deleteDirs(new File(dirName));
    }

    public static boolean deleteDirs(File dir) {
        if (dir == null) {
            return false;
        }
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                deleteDirs(file);
            } else {
                if (!file.delete()) {
                    return false;
                }
            }
        }
        return dir.delete();
    }

}
