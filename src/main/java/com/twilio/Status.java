package com.twilio;

public class Status {
	private Status() {}
	
	public static final String QUEUED = "queued";
	public static final String RINGING = "ringing";
	public static final String IN_PROGRESS = "in-progress";
	public static final String COMPLETED = "completed";
	public static final String FAILED = "failed";
	public static final String BUSY = "busy";
	public static final String NO_ANSWER = "no-answer";
	public static final String CANCELED = "canceled";
	public static final String SENT = "sent";
}
