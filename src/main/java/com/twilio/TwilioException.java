package com.twilio;

public class TwilioException extends Exception {
	private static final long serialVersionUID = 1L;
    private final Error error;
	
	public TwilioException(Error error) {
        super(error.toString());
        this.error = error;
    }

    public TwilioException(Error error, Throwable cause) {
        super(error.toString(), cause);
        this.error = error;
    }

    public Error getError() {
        return error;
    }
}
