package com.example.mall.mapper.wxpay;

public interface PayConstants {
    String NOTIFY_URL = "https://www.weixin.qq.com/wxpay/pay.php";
    String MCH_ID = "1900009191";// 商户号
    String MCH_SERIAL_NO = "";// 商户证书序列号
    String API_V3KEY = "aa";// API V3密钥
    String APP_ID = "wxd678efh567hg6787";
    String PACKAGE = "Sign=WXPay";

    // 你的商户私钥
    String PRIVATE_KEY = "-----BEGIN PRIVATE KEY-----\n" +
            "xxxxxx"
            + "-----END PRIVATE KEY-----\n";
}
