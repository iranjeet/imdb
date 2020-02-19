package com.example.page.dto.response;

import java.util.ArrayList;
import java.util.List;

public class ResGetAllGeneres {
	
	List<ResGetAllGeneres.ResGetAllGen> generes=new ArrayList<ResGetAllGeneres.ResGetAllGen>();
	
	
	public List<ResGetAllGeneres.ResGetAllGen> getGeneres() {
		return generes;
	}


	public void setGeneres(List<ResGetAllGeneres.ResGetAllGen> generes) {
		this.generes = generes;
	}


	public static class ResGetAllGen{
		private long id;
		private String name;
		public long getId() {
			return id;
		}
		public void setId(long id) {
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
