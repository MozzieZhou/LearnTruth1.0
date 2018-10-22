package com.gem.learntruth.miaodiyun.httpApiDemo;

import com.gem.learntruth.miaodiyun.httpApiDemo.common.Config;
import com.gem.learntruth.miaodiyun.httpApiDemo.common.HttpUtil;

import java.net.URLEncoder;

/**
 * 验证码通知短信接口
 *
 * @ClassName: IndustrySMS
 * @Description: 验证码通知短信接口
 */
public class IndustrySMS {
    private String operation = "/industrySMS/sendSMS";

    private String accountSid = Config.ACCOUNT_SID;
    private String to;
    private String smsContent;

    public IndustrySMS(String to, String smsContent) {
        this.to = to;
        this.smsContent = smsContent;
    }

    /**
     * 验证码通知短信
     */
    public String execute() {
        String tmpSmsContent = null;
        try {
            tmpSmsContent = URLEncoder.encode(smsContent, "UTF-8");
        } catch (Exception e) {

        }
        String url = Config.BASE_URL + operation;
        String body = "accountSid=" + accountSid + "&to=" + to + "&smsContent=" + tmpSmsContent
                + HttpUtil.createCommonParam();

        // 提交请求
        String result = HttpUtil.post(url, body);
        return "result:" + System.lineSeparator() + result;
    }
}
