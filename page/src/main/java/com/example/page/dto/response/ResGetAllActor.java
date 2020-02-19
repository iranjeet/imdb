package com.example.page.dto.response;

import java.util.List;

public class ResGetAllActor {
	
	private List<Long> id;
	public List<Long> getId() {
		return id;
	}

	public void setId(List<Long> id) {
		this.id = id;
	}

	private List<String> name;

	public List<String> getName() {
		return name;
	}

	public void setName(List<String> name) {
		this.name = name;
	}
	
	

}
