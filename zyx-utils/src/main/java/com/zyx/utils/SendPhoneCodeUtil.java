package com.zyx.utils;

import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Created by WeiMinSheng on 2016/6/12.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title com.zyx.utils.SendPhoneCodeUtil
 */
public class SendPhoneCodeUtil {
//    static JedisCluster jc;

//    private final HttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
//
//    static {
//        Set<HostAndPort> jedisClusterNodes = new HashSet<>();
//        jedisClusterNodes.add(new HostAndPort("125.208.1.67", 7000));
//        jedisClusterNodes.add(new HostAndPort("125.208.1.67", 7001));
//        jedisClusterNodes.add(new HostAndPort("125.208.1.67", 7002));
//        jedisClusterNodes.add(new HostAndPort("125.208.1.67", 7003));
//        jedisClusterNodes.add(new HostAndPort("125.208.1.67", 7004));
//        jedisClusterNodes.add(new HostAndPort("125.208.1.67", 7005));
//        jc = new JedisCluster(jedisClusterNodes);
//    }
//
//    private static class LazyHolder {
//        private static final HttpClientUtils INSTANCE = new HttpClientUtils();
//    }
//
//    private static HttpClientUtils getInstance() {
//        return LazyHolder.INSTANCE;
//    }
//
//
//    private HttpClientConnectionManager getConnManager() {
//        return connManager;
//    }


    /**
     * http Post 通用方法 Json传参
     *
     * @param params
     * @return
     */
    public static String send(String phone, String params) {
        String url = "http://www.mxtong.net.cn/GateWay/Services.asmx/DirectSend";

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader("Content-Disposition: form-data;name=media", "application/json; charset=utf-8");
            httpPost.setHeader("Accept", "application/json");

            //验证码
            String random = RandomUtil.generateNumString(4);

            String Content;
            if (params != null && !params.equals("")) {
                Content = java.net.URLEncoder.encode(params + "【体育家】", "UTF-8");
            } else {
                Content = java.net.URLEncoder.encode("验证码" + random + "，你正在使用体育家，感谢你的支持，体育家将持续为你服务！！！【体育家】", "UTF-8");
            }

            List<NameValuePair> data = new ArrayList<>();
            data.add(new BasicNameValuePair("UserID", "995836"));
            data.add(new BasicNameValuePair("Account", "admin"));
            data.add(new BasicNameValuePair("Password", "1JKY7K"));
            data.add(new BasicNameValuePair("Phones", phone));
            data.add(new BasicNameValuePair("SendType", "1"));
            data.add(new BasicNameValuePair("SendTime", ""));
            data.add(new BasicNameValuePair("PostFixNumber", ""));
            data.add(new BasicNameValuePair("Content", Content));
            httpPost.setEntity(new UrlEncodedFormEntity(data, UTF_8));
            CloseableHttpResponse response = httpClient.execute(httpPost);

            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
//                jc.set(phone + "data", random);
//                jc.set(phone, "");
//                jc.expire(phone + "data", 5 * 60);
//                jc.expire(phone, 60);
                return EntityUtils.toString(response.getEntity(), UTF_8);
            } else {
                return null;
            }
        } catch (IOException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(SendPhoneCodeUtil.send("18502826672", null));
    }
}
