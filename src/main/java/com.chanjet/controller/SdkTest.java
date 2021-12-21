package com.chanjet.controller;

import com.chanjet.openapi.sdk.java.DefaultChanjetClient;
import com.chanjet.openapi.sdk.java.domain.CreateTenantContent;
import com.chanjet.openapi.sdk.java.exception.ChanjetApiException;
import com.chanjet.openapi.sdk.java.request.CreateTenantRequest;
import com.chanjet.openapi.sdk.java.response.CreateTenantResponse;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import sun.net.www.http.HttpClient;

import java.util.HashMap;
import java.util.Map;

public class SdkTest {
    public static void main(String[] args) {
        try {
            //创建client
            DefaultChanjetClient defaultChanjetClient = new DefaultChanjetClient("https://openapi.chanjet.com");

            //创建请求对象
            CreateTenantRequest createTenantRequest = new CreateTenantRequest();

            //设置开放平台公共请求参数
            createTenantRequest.setAppKey("1nVg1Pom");
            createTenantRequest.setAppSecret("EDA816AB3EF8696095C8890F574F5F3E");
            createTenantRequest.setRequestUri("/tplus/api/v2/warehouse/Query");
            createTenantRequest.setOpenToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhY2Nlc3NfdG9rZW4iOiJhNDNhOGU1Yi00NTQ0LTQxZTEtYTA3Mi01MzYwN2I1MGM5N2MiLCJzdWIiOiJpc3YiLCJhdWQiOiJpc3YiLCJuYmYiOjE2MzIyMzQzMjcsImFwcElkIjoiNTgiLCJzY29wZSI6ImF1dGhfYWxsIiwiaXNzIjoiY2hhbmpldCIsImV4cCI6MTYzMjc1MjcyNywidXNlcklkIjoiNjAwMTQzNjIxNTEiLCJpYXQiOjE2MzIyMzQzMjcsIm9yZ0lkIjoiMTIzMjgwNjUwMzQ5NzkwMSIsIm9yZ0FjY291bnQiOiJ1enVzanEyZ3JsZTcifQ.IdyID0KvRrECbX73yJMcDM0TZsvHeaFPyeUE8bCzx2M");
            createTenantRequest.setContentType("application/json");

            createTenantRequest.addQueryParam("body","param:{}");

            //设置header参数,接口如无appKey、appSecret、appSecret、Content-Type四个参数之外的请求头，则不需要传
            //createTenantRequest.addHeader("key", "value");

            //Map<String,String>  addQueryParam = new HashMap<String,String>();
            //addQueryParam.put("Code","999");
            //addQueryParam.put("queryParams","{}");

            //设置query参数,接口无query参数则不需要传

            //createTenantRequest.addQueryParams(addQueryParam);


            //设置业务参数对象
            //CreateTenantContent createTenantContent = new CreateTenantContent();
            //createTenantContent.setTenantId("tenant_987... ...");
            //createTenantRequest.setBizContent(createTenantContent);
            //发起请求并响应
            CreateTenantResponse createTenantResponse = defaultChanjetClient.execute(createTenantRequest);
            if (createTenantResponse.getResult()) {
                System.out.println("调用成功。");
            } else {
                System.out.println("调用失败，原因：" + createTenantResponse.getError().getMsg());
            }
        } catch (ChanjetApiException e) {
            //做异常处理
            System.out.println("调用遭遇异常，原因：" + e.getMessage());
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
