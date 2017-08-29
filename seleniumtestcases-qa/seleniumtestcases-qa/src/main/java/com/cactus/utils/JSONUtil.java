package com.cactus.utils;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class JSONUtil {
	private static JSONUtil instance;

	private JSONUtil() {
	}

	public static JSONUtil getInstance() {
		if (instance == null) {
			instance = new JSONUtil();
		}
		return instance;
	}

	public JSONObject getJSONObject(String json_String) {
		return new JSONObject(json_String);
	}

	public String checkJSONObject(JSONObject jObject, String field) {
		String[] value = JSONObject.getNames(jObject);
		for (String str : value) {
			if (str.equalsIgnoreCase(field)) {
				String val = jObject.getString(str);
				return val;
			} else {
				if (jObject.optJSONObject(str) != null) {
					JSONObject jObject1 = jObject.getJSONObject(str);
					String val = checkJSONObject(jObject1, field);
					if (val != null) {
						return val;
					}
				}
			}
		}
		return null;

	}

	public Map<Integer, Integer> convertJSONStringToMap(String json_String) {
		//JSONObject jObject = new JSONObject(json_String);
		//String[] value = jObject.getNames(jObject);
		Map<Integer, Integer> questionsAnswerMap = new HashMap<Integer, Integer>();
		return questionsAnswerMap;
	}

}
