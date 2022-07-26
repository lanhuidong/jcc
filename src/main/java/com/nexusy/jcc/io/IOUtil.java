package com.nexusy.jcc.io;

import com.nexusy.jcc.exception.ResourceNotFoundException;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.function.Consumer;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipInputStream;

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
                String line;
                while ((line = br.readLine()) != null) {
                    consumer.accept(line);
                }
            }
        } catch (IOException e) {
            throw new ResourceNotFoundException("resource " + resourceName + " not found", e);
        }
    }

    public static void processFilePerLine(File file, Consumer<String> consumer) {
        String fileName = file.getName();
        if (fileName.endsWith(".gz")) {
            try (GZIPInputStream gis = new GZIPInputStream(new FileInputStream(file));
                 BufferedReader br = new BufferedReader(new InputStreamReader(gis))) {
                String line;
                while ((line = br.readLine()) != null) {
                    consumer.accept(line);
                }
            } catch (IOException e) {
                throw new com.nexusy.jcc.exception.IOException(e);
            }
        } else if (fileName.endsWith(".zip")) {
            try (ZipInputStream zis = new ZipInputStream(new FileInputStream(file));
                 BufferedReader br = new BufferedReader(new InputStreamReader(zis))) {
                while (zis.getNextEntry() != null) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        consumer.accept(line);
                    }
                    zis.closeEntry();
                }
            } catch (IOException e) {
                throw new com.nexusy.jcc.exception.IOException(e);
            }
        } else {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
                String line;
                while ((line = br.readLine()) != null) {
                    consumer.accept(line);
                }
            } catch (IOException e) {
                throw new com.nexusy.jcc.exception.IOException(e);
            }
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

    public static void bytesToFile(byte[] data, String fileName) {
        bytesToFile(data, new File(fileName));
    }

    public static void bytesToFile(byte[] data, File file) {
        try (BufferedOutputStream baos = new BufferedOutputStream(new FileOutputStream(file))) {
            baos.write(data);
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

    public static void copyFile(String srcFile, String destFile) {
        copyFile(new File(srcFile), new File(destFile));
    }

    public static void copyFile(File srcFile, File destFile) {
        try (FileInputStream fis = new FileInputStream(srcFile);
             FileOutputStream fos = new FileOutputStream(destFile);
             FileChannel srcChannel = fis.getChannel();
             FileChannel destChannel = fos.getChannel()) {
            destChannel.transferFrom(srcChannel, 0, srcChannel.size());
        } catch (FileNotFoundException e) {
            throw new com.nexusy.jcc.exception.FileNotFoundException(e);
        } catch (IOException e) {
            throw new com.nexusy.jcc.exception.IOException(e);
        }
    }

}
