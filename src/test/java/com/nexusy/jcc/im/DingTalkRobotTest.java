package com.nexusy.jcc.im;

import com.nexusy.jcc.io.IOUtil;
import com.nexusy.jcc.rest.RestResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * @author lanhuidong
 * @since 2022-08-09
 */
@Disabled("认证信息不方便放入代码库")
public class DingTalkRobotTest {

    private static String webhook;
    private static String secret;

    @BeforeAll
    public static void beforeAll() {
        IOUtil.processResourcePerLine("DingTalk.sec", line -> {
            if (webhook == null) {
                webhook = line;
            } else {
                secret = line;
            }
        });
    }

    @Test
    public void testSendText() {
        DingTalkRobot robot = new DingTalkRobot(webhook, secret);
        RestResponse<Void> response = robot.sendText("绿树阴浓夏日长，楼台倒影入池塘");
        Assertions.assertEquals(0, response.getCode());
    }

    @Test
    public void testSendMarkdown() {
        DingTalkRobot robot = new DingTalkRobot(webhook, secret);
        RestResponse<Void> response = robot.sendMarkdown("古诗", "<font color=#00FF00>绿</font>树阴浓夏日长，楼台倒影入池塘");
        Assertions.assertEquals(0, response.getCode());
    }
}
