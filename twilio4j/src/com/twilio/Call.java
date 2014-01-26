package com.twilio;

import java.io.IOException;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Call implements Serializable {
	private static final long serialVersionUID = 1L;
	
    /** Default constructor for JSON deserialization. */
    public Call() {}
    
    @JsonInclude(Include.NON_NULL)
    public String sid;
    
    @JsonInclude(Include.NON_NULL)
    public String date_created;
    
    @JsonInclude(Include.NON_NULL)
    public String date_updated;
    
    @JsonInclude(Include.NON_NULL)
    public String parent_call_sid;
    
    @JsonInclude(Include.NON_NULL)
    public String account_sid;
    
    @JsonInclude(Include.NON_NULL)
    public String to;
    
    @JsonInclude(Include.NON_NULL)
    public String formatted_to;
    
    @JsonInclude(Include.NON_NULL)
    public String from;
    
    @JsonInclude(Include.NON_NULL)
    public String formatted_from;
    
    @JsonInclude(Include.NON_NULL)
    public String phone_number_sid;
    
    @JsonInclude(Include.NON_NULL)
    public String status;
    
    @JsonInclude(Include.NON_NULL)
    public String start_time;
    
    @JsonInclude(Include.NON_NULL)
    public String end_time;
    
    @JsonInclude(Include.NON_NULL)
    public String duration;

    @JsonInclude(Include.NON_NULL)
    public String price;
    
    @JsonInclude(Include.NON_NULL)
    public String direction;
    
    @JsonInclude(Include.NON_NULL)
    public String answered_by;
    
    @JsonInclude(Include.NON_NULL)
    public String api_version;
    
    @JsonInclude(Include.NON_NULL)
    public String forwarded_from;
    
    @JsonInclude(Include.NON_NULL)
    public String caller_name;
    
    @JsonInclude(Include.NON_NULL)
    public String uri;
    
    @JsonInclude(Include.NON_NULL)
    public SubresourceUris subresource_uris;
    
	@Override
	public String toString() {
		try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}