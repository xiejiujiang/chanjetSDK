package com.chanjet.controller;

import com.chanjet.openapi.sdk.java.enums.HttpMethod;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import sun.net.www.http.HttpClient;

import java.io.IOException;

public class HttpRequestTest {

    public static void main(String[] args) {
        String uri = "https://openapi.chanjet.com/tplus/api/v2/warehouse/Query";
        //1、创建客户端，建立连接
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //2、创建POST请求
        HttpPost httpPost = new HttpPost(uri);
        //HttpParams params = new HashMa
        //httpPost.setParams();

        CloseableHttpResponse response = null;
        try {
            //3、发送请求
            response = httpClient.execute(httpPost);
            //4、获取响应数据
            if (response != null && response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                String context = EntityUtils.toString(entity, "utf-8");
                System.out.println(context);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //不管如何关闭响应、请求的连接
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
