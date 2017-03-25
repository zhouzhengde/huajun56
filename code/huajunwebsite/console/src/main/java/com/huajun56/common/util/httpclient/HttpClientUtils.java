package com.huajun56.common.util.httpclient;

import com.huajun56.common.util.Constants;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Http请求工具类
 * Created by Bond(China) on 2016/11/28.
 */
public final class HttpClientUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientUtils.class);

    private HttpClientUtils() {
    }

    /**
     * 执行POST方法调用
     *
     * @param url
     * @param inputStream
     * @param contentType
     * @return
     * @throws IOException
     */
    public static String post(String url, InputStream inputStream, long lenght, ContentType contentType) throws IOException {
        LOGGER.info("[Http Post] URL:" + url);
        LOGGER.info("[Http Post] Data: Stream");
        HttpPost post = new HttpPost(url);
        post.setEntity(new InputStreamEntity(inputStream, lenght));
        post.addHeader(Constants.CONTENT_TYPE, contentType.value);
        return sendRequest(post);
    }

    /**
     * 执行POST方法调用
     *
     * @param url
     * @param requestBody
     * @param contentType
     * @return
     * @throws IOException
     */
    public static String post(String url, String requestBody, ContentType contentType) throws IOException {
        LOGGER.info("[Http Post] URL:" + url);
        LOGGER.info("[Http Post] Data: " + requestBody);
        HttpPost post = new HttpPost(url);
        post.setEntity(new StringEntity(requestBody));
        post.addHeader(Constants.CONTENT_TYPE, contentType.value);
        return sendRequest(post);
    }

    /**
     * 执行POST方法调用
     *
     * @param url
     * @param params
     * @param contentType
     * @return
     * @throws IOException 考虑到有事务
     */
    public static String post(String url, Map<String, String> params, ContentType contentType) throws IOException {
        LOGGER.info("[Http Post] URL:" + url);
        LOGGER.info("[Http Post] Data: Map" + params.toString());
        HttpPost post = postForm(url, params);
        post.addHeader(Constants.CONTENT_TYPE, contentType.value);
        return sendRequest(post);
    }

    /**
     * 执行GET方法调用
     *
     * @param url
     * @param contentType
     * @return
     * @throws IOException 考虑到有事务
     */
    public static String get(String url, ContentType contentType) throws IOException {
        LOGGER.info("[Http Post] URL:" + url);
        HttpGet get = new HttpGet(url);
        get.addHeader(Constants.CONTENT_TYPE, contentType.value);
        return sendRequest(get);
    }

    /**
     * 执行POST方法调用
     *
     * @param url
     * @param requestBody
     * @return
     * @throws IOException
     */
    public static String post(String url, String requestBody) throws IOException {
        LOGGER.info("[Http Post] URL:" + url);
        LOGGER.info("[Http Post] Data:" + requestBody);
        HttpPost post = new HttpPost(url);
        post.setEntity(new StringEntity(requestBody));
        post.addHeader(Constants.CONTENT_TYPE, ContentType.TEXT_XML.value);
        return sendRequest(post);
    }

    /**
     * 执行POST方法调用
     *
     * @param url
     * @param params
     * @return
     * @throws IOException 考虑到有事务
     */
    public static String post(String url, Map<String, String> params) throws IOException {
        LOGGER.info("[Http Post] URL:" + url);
        LOGGER.info("[Http Post] Data: Map" + params.toString());
        HttpPost post = postForm(url, params);
        post.addHeader(Constants.CONTENT_TYPE, ContentType.TEXT_XML.value);
        return sendRequest(post);
    }

    /**
     * 执行GET方法调用
     *
     * @param url
     * @return
     * @throws IOException 考虑到有事务
     */
    public static String get(String url) throws IOException {
        LOGGER.info("[Http Post] URL:" + url);
        HttpGet get = new HttpGet(url);
        get.addHeader(Constants.CONTENT_TYPE, ContentType.TEXT_XML.value);
        return sendRequest(get);
    }

    /**
     * 发送Request
     *
     * @param method
     * @return
     * @throws IOException
     */
    private static String sendRequest(HttpRequestBase method) throws IOException {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        String body = null;
        try {
            HttpResponse response = httpClient.execute(method);
            body = parseResponse(response);
        } catch (IOException e) {
            throw e;
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
        LOGGER.info("[Http Post Result]" + body);
        return body;
    }

    /**
     * 解析响应
     *
     * @param response
     * @return
     */
    private static String parseResponse(HttpResponse response) throws IOException {
        HttpEntity entity = response.getEntity();
        return EntityUtils.toString(entity);
    }

    /**
     * 包装参数 For Post
     *
     * @param url
     * @param params
     * @return
     */
    private static HttpPost postForm(String url, Map<String, String> params) {
        HttpPost httppost = new HttpPost(url);
        List<NameValuePair> valuePairs = new ArrayList<NameValuePair>();
        Set<String> keys = params.keySet();
        for (String key : keys) {
            valuePairs.add(new BasicNameValuePair(key, params.get(key)));
        }
        httppost.setEntity(new UrlEncodedFormEntity(valuePairs, Consts.UTF_8));
        return httppost;

    }

    /**
     * ContentType
     */
    public enum ContentType {
        OCT_STREAM("application/octet-stream;charset=utf-8"), TEXT_XML("text/xml;charset=utf-8"), JSON("application/json;charset=utf-8");
        private String value;

        private ContentType(String value) {
            this.value = value;
        }
    }
}