package com.http.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;

public class HttpRequest {

    /**
     * 1.模拟get请求接口
     * 
     * @param url
     * @return
     */
    public static String doGet(String url) {

        String result = "";

        CloseableHttpClient httpClient = HttpClients.createDefault();// 获取httpclient对象
        HttpGet httpGet = new HttpGet(url);// 获取get请求对象
        CloseableHttpResponse response;// 请求响应

        try {
            response = httpClient.execute(httpGet);// 发起请求
            HttpEntity entity = response.getEntity();// 获取响应中的数据
            result = EntityUtils.toString(entity, "utf-8");// 把entity转换成字符串

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    // post无效
    public static String doPost(String url, Map<String, String> params) throws Exception {

        HttpPost httpPost = new HttpPost(url);
        CloseableHttpClient httpClient = HttpClients.createDefault();// 获取httpclient对象
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        if (params != null) {
            BasicNameValuePair bnvp = null;
            for (Map.Entry<String, String> p : params.entrySet()) {
                bnvp = new BasicNameValuePair(p.getKey(), p.getValue());
            }
        }
        httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        CloseableHttpResponse response = httpClient.execute(httpPost);
        HttpEntity respEntity = response.getEntity();// 获得返回数据
        String text = EntityUtils.toString(respEntity, "UTF-8");

        return text;
    }

    // 测试
    public static void main(String[] args) {
        // 1.get
        // String url = "http://47.97.125.255:8080/showUser3";
        // String doGet = doGet(url);
        // System.out.println(doGet);

        // 2.get带一个参数
        // String url = "http://47.97.125.255:8080/getUserById?id=3";
        // String doGet = doGet(url);
        // System.out.println(doGet);

        // 3.get带多个参数
        // String url =
        // "http://47.97.125.255:8080/getUserByIdName?id=3&name=xs";
        // String doGet = doGet(url);
        // System.out.println(doGet);

    }
}