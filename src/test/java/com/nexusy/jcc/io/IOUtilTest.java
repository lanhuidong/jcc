package com.nexusy.jcc.io;

import com.nexusy.jcc.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

/**
 * @author lanhuidong
 * @since 2022-02-17
 */
public class IOUtilTest {

    @Test
    void testGetResourceAsBytesWithNotExistResource() {
        Assertions.assertThrows(ResourceNotFoundException.class, () -> IOUtil.getResourceAsBytes("NotExistResource"));
    }

    @Test
    void testGetResourceAsBytes() {
        byte[] data = IOUtil.getResourceAsBytes("vim-go.png");
        Assertions.assertNotNull(data);
        Assertions.assertEquals(29252, data.length);
    }

    private Set<String> line;

    private final Consumer<String> linesConsumer = line -> this.line.add(line);

    @Test
    void testProcessResourcePerLine() {
        line = new HashSet<>();
        IOUtil.processResourcePerLine("feihua.txt", linesConsumer);
        Assertions.assertEquals(3, line.size());
        for (String liftNo : line) {
            System.out.println(liftNo);
        }
        line = null;
    }

    @Test
    void testFileToBytes() {
        byte[] data = IOUtil.fileToBytes("LICENSE");
        Assertions.assertNotNull(data);
        Assertions.assertEquals(11357, data.length);
    }

    @Test
    void testStreamToBytes() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("vim-go.png");
        byte[] data = IOUtil.streamToBytes(is);
        Assertions.assertNotNull(data);
        Assertions.assertEquals(29252, data.length);
    }

}
