package com.revature.charityappnotificationms.message;

public class Message {
	private String infoMessage;
	private String errorMessage;

	public String getInfoMessage() {
		return infoMessage;
	}

	public void setInfoMessage(String infoMessage) {
		this.infoMessage = infoMessage;
	}

	public void setErrorMessage(String error) {
		this.errorMessage = error;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public Message(String error) {
		super();
		this.errorMessage = error;

	}

	public static final String BAD_REQUEST = "Unable to send mail";
	public static final String OK = "Email sent successfully";

}
