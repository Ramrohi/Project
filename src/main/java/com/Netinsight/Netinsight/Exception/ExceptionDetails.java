package com.Netinsight.Netinsight.Exception;

public class ExceptionDetails {
	String exceptionId;
	String inputMessage;

	public ExceptionDetails(String exceptionId, String inputMessage) {
		this.exceptionId = exceptionId;
		this.inputMessage = inputMessage;
	}

	public String getExceptionId() {
		return exceptionId;
	}

	public void setExceptionId(String exceptionId) {
		this.exceptionId = exceptionId;
	}

	public String getInputMessage() {
		return inputMessage;
	}

	public void setInputMessage(String inputMessage) {
		this.inputMessage = inputMessage;
	}

}
