package com.example.page.dto.response;

import java.io.Serializable;

public class ResJwt implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String jwttoken;

	
	public ResJwt(String jwttoken) {
	
		this.jwttoken = jwttoken;
	}


	public String getJwttoken() {
		return jwttoken;
	}


}
