package com.sadhanoday.springbootexamples.customexceptions;

import java.util.Date;

public class CustomErrorInfo {

	private Date timestamp;
	private String message;
	private String errordetails;

	public CustomErrorInfo(Date timestamp, String message, String errordetails) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.errordetails = errordetails;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getErrordetails() {
		return errordetails;
	}

}
