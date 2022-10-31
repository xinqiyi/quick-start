package com.components.utils.response;

public enum CommonResponseCode {
	RC_SUCCESS("1", "success"),
	RC_PARAMETER_ERROR("commonerror001", "parameter invalid"),
	RC_EXCEPTION_ERROR("commonerror002", "service exception"),
	RC_NO_PERMISSION_ERROR("commonerror003", "no permission exception"),
	RC_NO_PRIMARY_ERROR("commonerror004", "No primary key when updating");

	private String responseCode;
	private String responseMessage;

	CommonResponseCode(String responseCode, String responseMessage) {
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
}
