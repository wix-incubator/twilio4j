package com.twilio;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Error implements Serializable {
	private static final long serialVersionUID = 1L;
	
    /** Default constructor for JSON deserialization. */
    public Error() {}
    
    @JsonInclude(Include.NON_NULL)
    public Integer status;
    
    @JsonInclude(Include.NON_NULL)
    public String message;
    
    @JsonInclude(Include.NON_NULL)
    public Integer code;
    
    @JsonInclude(Include.NON_NULL)
    public String more_info;
    
	@Override
	public String toString() {
		return "Error [status=" + status + ", message=" + message + ", code="
				+ code + ", more_info=" + more_info + "]";
	}
}