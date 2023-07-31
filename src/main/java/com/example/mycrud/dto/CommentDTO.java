package com.example.mycrud.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CommentDTO {
	
	@NotEmpty
	@Size(max = 255, message = "No debe sobrepasar los 255 caracteres")
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	

}
