package com.twilio;

import java.util.LinkedHashMap;
import java.util.Map;

public class CallParams {
	public final Map<String, String> params = new LinkedHashMap<String, String>();
	
	public CallParams() {}
	
	public void clear() {
		params.clear();
	}
	
	public void setFrom(String from) {
		params.put("From", from);
	}
	
	public void setTo(String to) {
		params.put("To", to);
	}
	
	public void setUrl(String url) {
		params.put("Url", url);
	}
	
	public void setSendDigits(String keys) {
		params.put("SendDigits", keys);
	}
	
	public void set(String name, String value) {
		params.put(name, value);
	}
}
