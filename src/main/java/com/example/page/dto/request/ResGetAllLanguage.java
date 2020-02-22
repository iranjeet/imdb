package com.example.page.dto.request;

import java.util.ArrayList;
import java.util.List;

public class ResGetAllLanguage {
	List<ResGetAllLang> getAllLanguage=new ArrayList<ResGetAllLanguage.ResGetAllLang>();
	
	public List<ResGetAllLang> getGetAllLanguage() {
		return getAllLanguage;
	}

	public void setGetAllLanguage(List<ResGetAllLang> getAllLanguage) {
		this.getAllLanguage = getAllLanguage;
	}

	public static class ResGetAllLang{
		private Long id;
		private String name;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}

}
