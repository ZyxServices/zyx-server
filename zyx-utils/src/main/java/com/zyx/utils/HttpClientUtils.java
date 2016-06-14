package com.zyx.utils;

import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Created by subdong on 16-1-21.
 */
public class HttpClientUtils {

    private final HttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();

    private static Logger log = LoggerFactory.getLogger(HttpClientUtils.class);

    private static class LazyHolder {
        private static final HttpClientUtils INSTANCE = new HttpClientUtils();
    }

    private static HttpClientUtils getInstance() {
        return LazyHolder.INSTANCE;
    }


    private HttpClientConnectionManager getConnManager() {
        return connManager;
    }


    /**
     * http Post 通用方法 Json传参
     *
     * @param params
     * @return
     */
    public static String postRequest(String url, Map<String, Object> params) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(url);

            List<NameValuePair> postParams = new ArrayList<>(params
                    .entrySet()
                    .stream()
                    .map(p -> new BasicNameValuePair(p.getKey(), p.getValue().toString()))
                    .collect(Collectors.toList())
            );
            httpPost.setEntity(new UrlEncodedFormEntity(postParams, UTF_8));
            CloseableHttpResponse response = httpClient.execute(httpPost);

            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                return EntityUtils.toString(response.getEntity(), UTF_8);
            } else {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * http Get 通用接口；
     *
     * @param url
     * @return 返回值
     * @throws IOException
     */
    public static String getRequestAuth(String url) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                return EntityUtils.toString(response.getEntity(), UTF_8);
            } else {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
