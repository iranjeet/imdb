package com.example.page.dto.response;

import java.util.ArrayList;
import java.util.List;

public class ResGetAllCountry {

	List<ResGetAllCount>  getAllCountry=new ArrayList<ResGetAllCountry.ResGetAllCount>();
		
	public List<ResGetAllCount> getGetAllCountry() {
		return getAllCountry;
	}


	public void setGetAllCountry(List<ResGetAllCount> getAllCountry) {
		this.getAllCountry = getAllCountry;
	}



	public static class ResGetAllCount{
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
