package com.twilio;

import java.util.LinkedHashMap;
import java.util.Map;

public class SmsParams {
	public final Map<String, String> params = new LinkedHashMap<String, String>();
	
	public SmsParams() {}
	
	public void clear() {
		params.clear();
	}
	
	public void setFrom(String from) {
		params.put("From", from);
	}
	
	public void setTo(String to) {
		params.put("To", to);
	}
	
	public void setBody(String body) {
		params.put("Body", body);
	}
}
