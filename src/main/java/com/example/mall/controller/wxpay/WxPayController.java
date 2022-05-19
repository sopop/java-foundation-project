package com.example.mall.controller.wxpay;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.wechat.pay.contrib.apache.httpclient.WechatPayHttpClientBuilder;
import com.wechat.pay.contrib.apache.httpclient.auth.AutoUpdateCertificatesVerifier;
import com.wechat.pay.contrib.apache.httpclient.auth.PrivateKeySigner;
import com.wechat.pay.contrib.apache.httpclient.auth.WechatPay2Credentials;
import com.wechat.pay.contrib.apache.httpclient.auth.WechatPay2Validator;
import com.wechat.pay.contrib.apache.httpclient.util.PemUtil;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Before;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;

import com.example.mall.mapper.wxpay.PayConstants;

@RestController
@RequestMapping("wxpay")
public class WxPayController {
    private CloseableHttpClient httpClient;
    private AutoUpdateCertificatesVerifier verifier;

    @Before
    public void setup() {
        try {
            PrivateKey merchantPrivateKey = PemUtil.loadPrivateKey(PayConstants.PRIVATE_KEY);

            //使用自动更新的签名验证器，不需要传入证书
            verifier = new AutoUpdateCertificatesVerifier(
                    new WechatPay2Credentials(PayConstants.MCH_ID, new PrivateKeySigner(PayConstants.MCH_SERIAL_NO, merchantPrivateKey)),
                    PayConstants.API_V3KEY.getBytes(StandardCharsets.UTF_8));

            httpClient = WechatPayHttpClientBuilder.create()
                    .withMerchant(PayConstants.MCH_ID, PayConstants.MCH_SERIAL_NO, merchantPrivateKey)
                    .withValidator(new WechatPay2Validator(verifier))
                    .build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


    @PostMapping("/create-order")
    public void createOrder(){
        try {
            HttpPost httpPost = new HttpPost("https://api.mch.weixin.qq.com/v3/pay/transactions/app");
            httpPost.addHeader("Accept", "application/json");
            httpPost.addHeader("Content-type","application/json; charset=utf-8");

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectMapper objectMapper = new ObjectMapper();

            ObjectNode rootNode = objectMapper.createObjectNode();
            rootNode.put("mchid", PayConstants.MCH_ID)
                    .put("appid", PayConstants.APP_ID)
                    .put("notify_url", PayConstants.NOTIFY_URL)
                    .put("description", "测试订单")
                    .put("out_trade_no", System.currentTimeMillis() + "");
            rootNode.putObject("amount")
                    .put("total", 1);
            rootNode.putObject("payer")
                    .put("openid", "oUpF8uMuAJO_M2pxb1Q9zNjWeS6o");

            objectMapper.writeValue(bos, rootNode);

            httpPost.setEntity(new StringEntity(bos.toString("UTF-8"), "UTF-8"));
            CloseableHttpResponse response = httpClient.execute(httpPost);

            String bodyAsString = EntityUtils.toString(response.getEntity());
            System.out.println(bodyAsString);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
