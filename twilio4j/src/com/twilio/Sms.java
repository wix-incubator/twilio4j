package com.twilio;

import java.io.IOException;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sms implements Serializable {
	private static final long serialVersionUID = 1L;
	
    /** Default constructor for JSON deserialization. */
    public Sms() {}

    @JsonInclude(Include.NON_NULL)
    public String account_sid;
 
    @JsonInclude(Include.NON_NULL)
    public String api_version;
    
    @JsonInclude(Include.NON_NULL)
    public String body;
    
    @JsonInclude(Include.NON_NULL)
    public String date_created;
    
    @JsonInclude(Include.NON_NULL)
    public String date_sent;
    
    @JsonInclude(Include.NON_NULL)
    public String date_updated;
    
    @JsonInclude(Include.NON_NULL)
    public String direction;
    
    @JsonInclude(Include.NON_NULL)
    public String from;
    
    @JsonInclude(Include.NON_NULL)
    public String price;
    
    @JsonInclude(Include.NON_NULL)
    public String sid;
    
    @JsonInclude(Include.NON_NULL)
    public String status;
    
    @JsonInclude(Include.NON_NULL)
    public String to;

    @JsonInclude(Include.NON_NULL)
    public String uri;
    
	@Override
	public String toString() {
		try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}