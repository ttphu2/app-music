/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import constant.Constants;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;
import org.apache.commons.lang3.StringUtils;
import util.HashUtil;

/**
 *
 * @author hocgioinhatlop
 */
public class DataHubService {

    public DataHubService() {
    }
    
    //API ZING MP3
    private String getParamsString(Map<String, String> params) 
      throws UnsupportedEncodingException{
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()) {
          result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
          result.append("=");
          result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
          result.append("&");
        }

        String resultString = result.toString();
        return resultString.length() > 0
          ? resultString.substring(0, resultString.length() - 1)
          : resultString;
    }
    private String getDataFromUrl(String urlStr, Map<String, String> params) throws IOException{

        urlStr = urlStr + getParamsString(params);
        System.out.println(urlStr);
        CookieManager cookieManager = new CookieManager();
        URL url = new URL(urlStr);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        String cookiesHeader = connection.getHeaderField("Set-Cookie");
        if (cookiesHeader != null && !cookiesHeader.isEmpty()) {
            List<HttpCookie> cookies = HttpCookie.parse(cookiesHeader);
            cookies.forEach(cookie -> cookieManager.getCookieStore().add(null, cookie));
        }

        connection.disconnect();
        connection = (HttpURLConnection) url.openConnection();

        connection.setRequestProperty("Cookie",
                StringUtils.join(cookieManager.getCookieStore().getCookies(), ";"));
        connection.setRequestProperty("Accept", "*/*");
        connection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
        connection.setRequestProperty("Accept-Encoding", "gzip");
        connection.setRequestProperty("Connection", "Keep-Alive");
        connection.setRequestProperty("Host", "zingmp3.vn");
//Get Response  
        Reader reader = null;
        if ("gzip".equals(connection.getContentEncoding())) {
            reader = new InputStreamReader(new GZIPInputStream(connection.getInputStream()));
        } else {
            reader = new InputStreamReader(connection.getInputStream());
        }
        BufferedReader in = new BufferedReader(reader);
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        System.out.println(content.toString());      
        in.close();
        connection.disconnect();
        return content.toString();
    }
    public String getHomeData() {
        try {
            String ctime = getCtime();
            System.out.println();
            Map<String, String> params = new HashMap<>();
            params.put("page", "1");
            params.put("segmentId", "-1");
            params.put("ctime", ctime);
            params.put("version", constant.Constants.ZING_VERSION);
            params.put("sig", HashUtil.genarateSignature(ctime, "/api/v2/page/get/home", null,"1"));
            params.put("apiKey", Constants.ZING_API_KEY);
            String content = getDataFromUrl("https://zingmp3.vn/api/v2/page/get/home?",params);
            System.out.println(content.toString());
            return content.toString();
        } catch (IOException ex) {
            Logger.getLogger(DataHubService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    private String getCtime() {
        Long datetime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(datetime);
        return String.valueOf(Math.round(timestamp.getTime() / 1e3));
    }
    private void downloadUsingStream(String urlStr, String file) throws IOException{
        URL url = new URL(urlStr);
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fis = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int count=0;
        while((count = bis.read(buffer,0,1024)) != -1)
        {
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();
    }
    
}
