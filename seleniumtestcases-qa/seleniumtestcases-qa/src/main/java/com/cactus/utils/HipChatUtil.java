package com.cactus.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HipChatUtil {
	  public synchronized void javaCurlSendHipchat(String Message) {
		String bodyStr = "{\"message\":\""+Message+"\",\"notify\":false,\"message_format\":\"text\"}";
	       InputStream body = null;
		try {
			body = new ByteArrayInputStream(bodyStr.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	      // Assert.assertEquals('a','c');
	       System.out.println("Sending POST");
	       post("https://cactusglobal.hipchat.com/v2/room/4021248/notification?auth_token=qyQIirFURjuRsptM5cjP3XqmxXR5aTYX6V6nDNVf",body);
	       System.out.println("");
	   }

	   public void post(String targetUrl,
	           InputStream body) {
	       HttpURLConnection http = null;
	       try {
	           http = (HttpURLConnection) new URL(targetUrl).openConnection();
	           http.setRequestMethod("POST");
	           http.setRequestProperty("Content-Type", "application/json");
	           http.setDoOutput(true);
	           OutputStream out = http.getOutputStream();
	           out.write(readInput(body));
	           out.close();

	           InputStream in = http.getInputStream();
	           String response = new String(readInput(in), "UTF-8");

	           System.out.println("Response code: " + http.getResponseCode());
	           System.out.println("Response headers : " + http.getHeaderFields());
	           System.out.println("response from server: " + response);


	       } catch (IOException e) {
	           e.printStackTrace();
	       }

	   }

	   public byte[] readInput(InputStream in) {
	       ByteArrayOutputStream bais = new ByteArrayOutputStream();
	       byte[] buffer = new byte[1024];
	       int readLen = -1;
	       try {
	           while ((readLen = in.read(buffer)) != -1) {
	               bais.write(buffer, 0, readLen);
	           }
	           in.close();
	       } catch (IOException e) {
	           e.printStackTrace();
	       }

	       return bais.toByteArray();
	   }
	
	
}
