package com.parkdt.tml.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class HttpPostClient {

    private static Logger logger = LoggerFactory.getLogger(HttpPostClient.class);

    public static String doHttpPost(String webPath, String method, Map<String, String> param) {
        List<NameValuePair> p = null;
        if (param != null && !param.isEmpty()) {
            p = new ArrayList<NameValuePair>();
            Set<String> keys = param.keySet();
            for (String key : keys) {
                p.add(new BasicNameValuePair(key, param.get(key)));
            }
        }
        return doHttpPost(webPath, method, p);
    }

    @SuppressWarnings("deprecation")
    private static String doHttpPost(String webPath, String method, List<NameValuePair> param) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String url = webPath;
        if (StringKit.isNotEmpty(method)) {
            url += method;
        }
        HttpEntity paramEntity;
        StringBuffer buffer = new StringBuffer();
        try {
            HttpPost httpPost = new HttpPost(url);
            if (param != null) {
                paramEntity = new UrlEncodedFormEntity(param, StandardCharsets.UTF_8);
                httpPost.setEntity(paramEntity);
            }
            HttpResponse response = httpclient.execute(httpPost);
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(responseEntity.getContent(), "UTF-8"));
                String str = "";
                while (((str = reader.readLine()) != null)) {
                    buffer.append(str);
                }
                reader.close();
                responseEntity.getContent().close();
                httpPost.abort();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    @SuppressWarnings("deprecation")
    public static String doHttpGet(String url) {
//       HttpClient httpclient = new DefaultHttpClient(); 
        StringBuffer buffer = new StringBuffer();
        String result = "";
        try {
            BufferedReader in = null;
            URL realUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();

            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String doHttPostIO(String url, String param) {
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);

            if (StringKit.isNotEmpty(param)) {
                conn.getOutputStream().write(param.getBytes("utf-8"));
            }
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            logger.error("发送 POST 请求出现异常！" + e);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

}
