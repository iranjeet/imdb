package com.example.page.dto.response;

import java.util.ArrayList;
import java.util.List;

public class ResGetAllDirector {
	List<ResGetAllDirector.ResGetAllDir> director = new ArrayList<ResGetAllDirector.ResGetAllDir>();

	

	public List<ResGetAllDirector.ResGetAllDir> getDirector() {
		return director;
	}



	public void setDirectors(List<ResGetAllDirector.ResGetAllDir> director) {
		this.director = director;
	}



	public static class ResGetAllDir {

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
