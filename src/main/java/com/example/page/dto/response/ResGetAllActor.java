package com.example.page.dto.response;

import java.util.ArrayList;
import java.util.List;

public class ResGetAllActor {

	List<ResGetAllActor.ResGetAllAct> actors = new ArrayList<ResGetAllActor.ResGetAllAct>();

	public List<ResGetAllActor.ResGetAllAct> getActors() {
		return actors;
	}

	public void setActors(List<ResGetAllActor.ResGetAllAct> actors) {
		this.actors = actors;
	}

	public static class ResGetAllAct {

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
