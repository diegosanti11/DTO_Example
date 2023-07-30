package com.example.mycrud.Service;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class PersonaDosDTO {
	
	private long id;

	@NotEmpty
	@Size(min = 2, message = "full name should have at least 2 characters")
	private String fullName;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public PersonaDosDTO(long id,String fullName) {
		this.id = id;
		this.fullName = fullName;
	}

	public PersonaDosDTO() {
	}
	

	
}
