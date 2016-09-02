package com.zyx.utils.easemob;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Rainbow on 2016/8/31.
 */
public class EasemobAppKey {

    private final static String EASEMOB_ACCESS_TOKEN = "access_token";

    private final static String EASEMOB_EXPORES_IN = "expires_in";

    /**
     * 获取体育家环信 access_token
     *
     * @return
     */
    public static void getEasemobAppKey(RedisTemplate<String, String> stringRedisTemplate) {
        HttpClientBuilder clientBuilder = HttpClientBuilder.create();

        try (CloseableHttpClient httpclient = clientBuilder.build()) {

            HttpPost httpPost = new HttpPost("https://a1.easemob.com/shixuanleiim/sportclub/token");

            JSONObject jsonParam = new JSONObject();
            jsonParam.put("grant_type", "client_credentials");
            jsonParam.put("client_id", "YXA6Q8ZDkGkXEea8e1XVHR0FAg");
            jsonParam.put("client_secret", "YXA6VKUezN6o0ORnPh6HbOVCBHQKUQU");
            StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            httpPost.addHeader("Content-Type", "application/json");
            HttpResponse httpResponse = httpclient.execute(httpPost);
            int i = 1;
            while (true) {
                try {
                    StatusLine line = httpResponse.getStatusLine();
                    HttpEntity entitys = httpResponse.getEntity();

                    if (line.getStatusCode() == 200 && entitys != null) {
                        String results = EntityUtils.toString(entitys, "UTF-8");
                        if (results.contains(EASEMOB_ACCESS_TOKEN) && results.contains(EASEMOB_EXPORES_IN)) {
                            JSONObject parse = (JSONObject) JSONObject.parse(results);
                            stringRedisTemplate.opsForValue().set(EASEMOB_ACCESS_TOKEN, parse.get(EASEMOB_ACCESS_TOKEN).toString(), Long.valueOf(parse.get(EASEMOB_EXPORES_IN).toString()), TimeUnit.SECONDS);
                            break;
                        } else {
                            if (i >= 3) break;
                            i++;
                        }
                    } else {
                        if (i >= 3) break;
                        i++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (i >= 3) break;
                    i++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 通过群组ID获取当前直播在线人数
     *
     * @param redis
     * @param groupId
     * @return
     */
    public static Long getEasemobGroupUserinfo(RedisTemplate<String, String> redis, Long groupId) {

        HttpClientBuilder clientBuilder = HttpClientBuilder.create();

        try (CloseableHttpClient httpclient = clientBuilder.build()) {
            String access_token = redis.opsForValue().get(EASEMOB_ACCESS_TOKEN);
            if (access_token != null && !access_token.equals("")) {
                getEasemobAppKey(redis);
                access_token = redis.opsForValue().get(EASEMOB_ACCESS_TOKEN);
            }

            HttpGet httpGet = new HttpGet("https://a1.easemob.com/shixuanleiim/sportclub/chatgroups/" + groupId + "/users");

            httpGet.setHeader("Authorization", "Bearer " + access_token);
            HttpResponse httpResponse = httpclient.execute(httpGet);

            StatusLine line = httpResponse.getStatusLine();

            if (line.getStatusCode() == 401) {
                getEasemobAppKey(redis);
                access_token = redis.opsForValue().get(EASEMOB_ACCESS_TOKEN);
                httpGet.setHeader("Authorization", access_token);
                httpResponse = httpclient.execute(httpGet);
                line = httpResponse.getStatusLine();
            }

            HttpEntity entitys = httpResponse.getEntity();

            if (line.getStatusCode() == 200 && entitys != null) {
                String results = EntityUtils.toString(entitys, "UTF-8");
                if (results.contains("data") && results.contains("action")) {
                    JSONObject parse = (JSONObject) JSONObject.parse(results);
                    JSONArray data = (JSONArray) parse.get("data");
                    return (long) data.size();
                } else {
                    return 0l;
                }
            } else {
                return 0l;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0l;
        }
    }

}
