package com.example.mycrud.Service;

public class PersonaDTO {
	
	String ubication;
	
	String position;
	
	String fullName;
	
	String image;

	public String getUbication() {
		return ubication;
	}

	public void setUbication(String ubication) {
		this.ubication = ubication;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public PersonaDTO(String ubication, String position, String fullName, String image) {
		super();
		this.ubication = ubication;
		this.position = position;
		this.fullName = fullName;
		this.image = image;
	}

	public PersonaDTO() {
	}
	
	

}
