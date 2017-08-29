package com.cactus.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class APIUtil {
	public HttpResponse callURL(String getURL) throws ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(getURL);

		HttpResponse response = client.execute(request);
		return response;
	}

	public String getQuestionFeedback(String env, String serviceId, String partnerId, String clientType)
			throws ClientProtocolException, IOException {

		String envValue = "";
		if (!env.equalsIgnoreCase("live")) {
			envValue = env + ".";
		}
		String getURL = "https://" + envValue + "app.editage.jp/api/question/feedback?service_id=" + serviceId
				+ "&partner_id=" + partnerId + "&component_type=job&client_type=" + clientType
				+ "&worker_code=Test&lang=ja";
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(getURL);

		HttpResponse response = client.execute(request);
		HttpEntity entity = response.getEntity();

		return new JSONObject(EntityUtils.toString(entity, "UTF-8")).toString();
	}

}
