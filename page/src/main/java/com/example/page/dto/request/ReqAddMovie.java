package com.example.page.dto.request;

import java.util.List;

public class ReqAddMovie {
		
	private String name;
	
	private String releaseDate;
	
	public List<Long> actorIds;

	private Long directorId;
	
	private Long productionId;
	
	private Long genreId;
	
	private String language;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public List<Long> getActorIds() {
		return actorIds;
	}

	public void setActorIds(List<Long> actorIds) {
		this.actorIds = actorIds;
	}

	public Long getDirectorId() {
		return directorId;
	}

	public void setDirectorId(Long directorId) {
		this.directorId = directorId;
	}

	public Long getProductionId() {
		return productionId;
	}

	public void setProductionId(Long productionId) {
		this.productionId = productionId;
	}

	public Long getGenreId() {
		return genreId;
	}

	public void setGenreId(Long genreId) {
		this.genreId = genreId;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	
}
