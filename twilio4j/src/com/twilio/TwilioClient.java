package com.twilio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.UrlEncodedContent;

public class TwilioClient {
	private static final String TWILIO_API_URL = "https://api.twilio.com/2010-04-01/";
	
    private static final ObjectMapper mapper = new ObjectMapper();
    
	private final HttpRequestFactory requestFactory;
	private final Integer connectTimeout;
	private final Integer readTimeout;
	private final String accountSid;
	private final String basicAuth;
	
	public TwilioClient(HttpRequestFactory requestFactory, Integer connectTimeout, Integer readTimeout,
			String accountSid, String authToken) {
		this.requestFactory = requestFactory;
		this.connectTimeout = connectTimeout;
		this.readTimeout = readTimeout;
		this.accountSid = accountSid;
		
		final String userpass = accountSid + ":" + authToken;
		try {
			basicAuth = "Basic " + Base64.encodeBase64String(userpass.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public TwilioClient(HttpRequestFactory requestFactory, String accountSid, String authToken) {
		this(requestFactory, null, null, accountSid, authToken);
	}
	
	public Call makeCall(CallParams params) throws TwilioException, IOException {
		return go(TWILIO_API_URL + "Accounts/" + accountSid + "/Calls.json", params.params, new TypeReference<Call>() {});
	}
	
	public Call getCall(String callSid) throws TwilioException, IOException {
		return go(TWILIO_API_URL + "Accounts/" + accountSid + "/Calls/" + callSid + ".json", null, new TypeReference<Call>() {});
	}
	
	public Sms sendSms(SmsParams params) throws TwilioException, IOException {
		return go(TWILIO_API_URL + "Accounts/" + accountSid + "/SMS/Messages.json", params.params, new TypeReference<Sms>() {});
	}
	
	public Sms getSms(String smsSid) throws TwilioException, IOException {
		return go(TWILIO_API_URL + "Accounts/" + accountSid + "/SMS/Messages/" + smsSid + ".json", null, new TypeReference<Sms>() {});
	}
	
    private <T> T go(String url, Map<String, String> params, TypeReference<T> responseType) throws TwilioException, IOException {
    	final HttpRequest request;
    	if (params != null) {
        	request = requestFactory.buildPostRequest(new GenericUrl(url), new UrlEncodedContent(params));
    	} else {
        	request = requestFactory.buildGetRequest(new GenericUrl(url));
    	}
        if (connectTimeout != null) {
        	request.setConnectTimeout(connectTimeout.intValue());
        }
        if (readTimeout != null) {
        	request.setReadTimeout(readTimeout);
        }
    	
    	request.getHeaders().setAuthorization(basicAuth);
    	request.getHeaders().setAccept("application/json");

    	final HttpResponse response = request.execute();
    	try {
            final BufferedReader br = new BufferedReader(new InputStreamReader(response.getContent(), "UTF-8"));
            try {
            	return mapper.readValue(br, responseType);
            } finally {
                br.close();
            }
    	} finally {
    		response.ignore();
    	}
    }
}
