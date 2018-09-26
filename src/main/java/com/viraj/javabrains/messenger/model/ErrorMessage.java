package com.viraj.javabrains.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {

	private String errorMessage;
	private int errorCode;
	private String documentation;
	
	public ErrorMessage() {
	}

	public ErrorMessage(String errorMessage, int errorCode, String documentation) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		this.documentation = documentation;
	}

	public final String getErrorMessage() {
		return errorMessage;
	}

	public final void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public final int getErrorCode() {
		return errorCode;
	}

	public final void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public final String getDocumentation() {
		return documentation;
	}

	public final void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
	
	
}
