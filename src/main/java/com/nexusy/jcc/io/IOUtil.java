package com.nexusy.jcc.io;

import com.nexusy.jcc.exception.ResourceNotFoundException;

import java.io.*;
import java.util.function.Consumer;

/**
 * @author lanhuidong
 * @since 2022-02-17
 */
public final class IOUtil {

    private static final int BUFFER_SIZE = 4096;

    private IOUtil() {
    }

    public static byte[] getResourceAsBytes(String resourceName) {
        try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(resourceName);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            if (is == null) {
                throw new ResourceNotFoundException("resource " + resourceName + " not found");
            }
            copyBytes(is, baos);
            return baos.toByteArray();
        } catch (IOException e) {
            throw new ResourceNotFoundException("resource " + resourceName + " not found", e);
        }
    }

    public static void processResourcePerLine(String resourceName, Consumer<String> consumer) {
        try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(resourceName)) {
            if (is == null) {
                throw new ResourceNotFoundException("resource " + resourceName + " not found");
            }
            try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                String s;
                while ((s = br.readLine()) != null) {
                    consumer.accept(s);
                }
            }
        } catch (IOException e) {
            throw new ResourceNotFoundException("resource " + resourceName + " not found", e);
        }
    }

    public static byte[] fileToBytes(String fileName) {
        return fileToBytes(new File(fileName));
    }

    public static byte[] fileToBytes(File file) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            copyBytes(bis, baos);
            return baos.toByteArray();
        } catch (FileNotFoundException e) {
            throw new com.nexusy.jcc.exception.FileNotFoundException(e);
        } catch (IOException e) {
            throw new com.nexusy.jcc.exception.IOException(e);
        }
    }

    public static byte[] streamToBytes(InputStream stream) {
        try (InputStream is = stream;
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            copyBytes(is, baos);
            return baos.toByteArray();
        } catch (IOException e) {
            throw new com.nexusy.jcc.exception.IOException(e);
        }
    }

    private static void copyBytes(InputStream is, ByteArrayOutputStream baos) throws IOException {
        byte[] buf = new byte[BUFFER_SIZE];
        int len;
        while ((len = is.read(buf)) != -1) {
            baos.write(buf, 0, len);
        }
    }

}
