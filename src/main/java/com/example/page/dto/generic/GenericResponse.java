package com.example.page.dto.generic;

public class GenericResponse {

	private Boolean apiSucessStatus;
	
	private String apiMessage;

	public Boolean getApiSucessStatus() {
		return apiSucessStatus;
	}

	public void setApiSucessStatus(Boolean apiSucessStatus) {
		this.apiSucessStatus = apiSucessStatus;
	}

	public String getApiMessage() {
		return apiMessage;
	}

	public void setApiMessage(String apiMessage) {
		this.apiMessage = apiMessage;
	}
	
}
