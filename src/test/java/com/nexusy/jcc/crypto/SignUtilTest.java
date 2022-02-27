package com.nexusy.jcc.crypto;

import com.nexusy.jcc.io.IOUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author lanhuidong
 * @since 2022-02-27
 */
public class SignUtilTest {

    @Test
    void testMd5() {
        String md5 = SignUtil.md5(IOUtil.getResourceAsBytes("vim-go.png"));
        Assertions.assertEquals("03783ad14b64a9a2f2efb11035db496a", md5);
        md5 = SignUtil.md5("Write the Fucking Code");
        Assertions.assertEquals("850ff270b529e084f30c215f833be392", md5);
    }

    @Test
    void testHmacSHA1() {
        byte[] mac = SignUtil.hmacSHA1("Coding can shorten your life", "anonymous");
        String macHex = SignUtil.bytesToHexString(mac);
        Assertions.assertEquals("3dc630f6ba7e922a245e906b7d1a538117f482e9", macHex);
    }

    @Test
    void testHmacSHA256() {
        byte[] mac = SignUtil.hmacSHA256("Coding can shorten your life", "anonymous");
        String macHex = SignUtil.bytesToHexString(mac);
        Assertions.assertEquals("0b0e5ce8dc3051cabaf899021cc25e10d68b270ad24db12eec7f9d064c1b307c", macHex);
    }

}
