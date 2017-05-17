package com.simon.mybilibili.utils;

import android.support.annotation.NonNull;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xmg on 2017/5/11.
 * 实现网络请求  GET/POST
 */

public class NetworkUtil {

    public static String doGet(String urlStr, HashMap<String,String> params){
        // HttpUrlConnection  HttpClient Volley  okHttp  Retrofit ..
        try {
            String paramsStr = parseParams(params);
            URL url=new URL(urlStr+"?"+paramsStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            if (conn.getResponseCode()==200){
                InputStream is = conn.getInputStream();
                BufferedReader reader=new BufferedReader(new InputStreamReader(is));
                return reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 通过HttpUrlConnection实现一个POST请求
     * */
    public static String doPost(String urlStr,HashMap<String,String> params){

        URL url= null;
        try {
            url = new URL(urlStr);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            //向服务器写数据(写出去)   params-->paramsStr
            String paramsStr = parseParams(params);
            conn.setDoOutput(true);
            conn.getOutputStream().write(paramsStr.getBytes());
            if (conn.getResponseCode()==200){
                InputStream is = conn.getInputStream();
                BufferedReader reader=new BufferedReader(new InputStreamReader(is));
                return reader.readLine();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            Log.v("cherish233","MalformedURLException");
        } catch (ProtocolException e) {
            e.printStackTrace();
            Log.v("cherish233","ProtocolException");
        } catch (IOException e) {
            e.printStackTrace();
            Log.v("cherish233","IOException");
        }
        return "";
    }

    @NonNull
    private static String parseParams(HashMap<String, String> params) {
        String paramsStr="";//  username=2&pwd=123456&
        if (params==null||params.isEmpty()){
            return "";
        }
        for(Map.Entry<String,String> entry:params.entrySet()){
            paramsStr+=entry.getKey()+"="+entry.getValue()+"&";
        }
        paramsStr=paramsStr.substring(0,paramsStr.length()-1);
        return paramsStr;
    }

}
