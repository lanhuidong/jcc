package com.nexusy.jcc.crypto;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author lanhuidong
 * @since 2022-02-27
 */
public final class SignUtil {

    public static final String ALG_HMAC_SHA1 = "HmacSHA1";

    public static final String ALG_HMAC_SHA256 = "HmacSHA256";

    public static final String ALG_MD5 = "MD5";

    private static final char[] HEX = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        'a', 'b', 'c', 'd', 'e', 'f'};

    private SignUtil() {
    }

    public static String bytesToHexString(byte[] bytes) {
        char[] hexes = new char[bytes.length * 2];
        int index = 0;
        for (byte aByte : bytes) {
            hexes[index++] = HEX[aByte >>> 4 & 0xf];
            hexes[index++] = HEX[aByte & 0xf];
        }
        return new String(hexes);
    }

    public static String md5(String plainText) {
        return md5(plainText.getBytes(StandardCharsets.UTF_8));
    }

    public static String md5(byte[] plainBytes) {
        try {
            MessageDigest md = MessageDigest.getInstance(ALG_MD5);
            md.update(plainBytes);
            byte[] cipherBytes = md.digest();
            return bytesToHexString(cipherBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new com.nexusy.jcc.exception.NoSuchAlgorithmException(e);
        }
    }

    public static byte[] hmacSHA1(String text, String key) {
        return hmac(text, key, ALG_HMAC_SHA1);
    }

    public static byte[] hmacSHA256(String text, String key) {
        return hmac(text, key, ALG_HMAC_SHA256);
    }

    private static byte[] hmac(String text, String key, String algorithm) {
        try {
            SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), algorithm);
            Mac mac = Mac.getInstance(algorithm);
            mac.init(signingKey);
            return mac.doFinal(text.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            throw new com.nexusy.jcc.exception.NoSuchAlgorithmException(e);
        } catch (InvalidKeyException e) {
            throw new com.nexusy.jcc.exception.InvalidKeyException(e);
        }
    }

}
