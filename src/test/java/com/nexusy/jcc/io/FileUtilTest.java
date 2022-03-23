package com.nexusy.jcc.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @author lanhuidong
 * @since 2022-03-23
 */
public class FileUtilTest {

    @Test
    void testDeleteDirs() {
        File file = new File("com/nexusy/jcc");
        Assertions.assertTrue(file.mkdirs());
        Assertions.assertTrue(FileUtil.deleteDirs("com"));
    }

}
