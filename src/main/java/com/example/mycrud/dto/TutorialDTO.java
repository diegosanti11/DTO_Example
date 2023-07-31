package com.example.mycrud.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class TutorialDTO {
	
	@NotEmpty
	@Size(max = 255, message = "No debe sobrepasar los 255 caracteres")
	private String title;

	private String description;

	private boolean published;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}
	  
	  

}
