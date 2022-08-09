package com.nexusy.jcc.im;

import com.nexusy.jcc.crypto.SignUtil;
import com.nexusy.jcc.rest.RestResponse;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Base64;

/**
 * 参考资料：
 * <ol>
 *     <li><a href="https://open.dingtalk.com/document/group/custom-robot-access">机器人接入</a></li>
 *     <li><a href="https://open.dingtalk.com/document/group/message-types-and-data-format">消息格式</a></li>
 * </ol>
 *
 * @author lanhuidong
 * @since 2022-08-09
 */
public class DingTalkRobot {

    private final String webhook;
    private final String secret;
    private final HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10)).build();

    public DingTalkRobot(String webhook, String secret) {
        this.webhook = webhook;
        this.secret = secret;
    }

    public RestResponse<Void> sendText(String content) {
        String message = "{\"msgtype\": \"text\",\"text\": {\"content\":\"" + content + "\"}}";
        return sendHttpRequest(message);
    }

    public RestResponse<Void> sendMarkdown(String title, String content) {
        String message = "{\"msgtype\": \"markdown\",\"markdown\": {\"title\":\"" + title + "\",\"text\": \"" + content + "\"}}";
        return sendHttpRequest(message);
    }

    private RestResponse<Void> sendHttpRequest(String message) {
        long timestamp = System.currentTimeMillis();
        String string2sign = timestamp + "\n" + secret;
        byte[] signData = SignUtil.hmacSHA256(string2sign, secret);
        String sign = URLEncoder.encode(Base64.getEncoder().encodeToString(signData), StandardCharsets.UTF_8);
        HttpRequest request = HttpRequest
            .newBuilder(URI.create(webhook + "&timestamp=" + timestamp + "&sign=" + sign))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(message))
            .timeout(Duration.ofSeconds(10))
            .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
            String body = response.body();
            return RestResponse.failed(Integer.parseInt(parseByKey(body, "errcode")), parseByKey(body, "errmsg"));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /*
     * 响应示例：
     * {"errcode":0,"errmsg":"ok"}
     * {"errcode":310000,"errmsg":"description:机器人发送签名不匹配;solution:请确认签名和生成签名的时间戳必须都放在调用的网址中，请确认机器人的密钥加密和填写正确;link:请参考本接口对应文档获得具体要求，或者在https://open.dingtalk.com/document/  搜索相关文档;"}
     */
    private static String parseByKey(String text, String key) {
        int startIndex = text.indexOf("\"" + key + "\":");
        int endIndex = text.indexOf(",", startIndex);
        if (endIndex == -1) {
            endIndex = text.indexOf("}", startIndex);
        }
        String result = text.substring(startIndex + key.length() + 3, endIndex);
        if (result.startsWith("\"")) {
            result = result.substring(1, result.length() - 1);
        }
        return result;
    }

}
