package com.example.mycrud.Controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mycrud.Model.Comment;
import com.example.mycrud.Service.CommentService;
import com.example.mycrud.dto.CommentDTO;

@RestController
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@GetMapping("/tutorials/{tutorialId}/comments")
	public ResponseEntity<List<Comment>> getAllCommentsByTutorialId(@PathVariable(value = "tutorialId") Long tutorialId) {
		

		List<Comment> comments= commentService.getCommentsTuto(tutorialId);
		
		
	    return new ResponseEntity<>(comments, HttpStatus.OK);
	  }

	
	
	@PostMapping("/tutorial/{tutorialId}/comment")
	public ResponseEntity<Comment> createComment(@PathVariable(value = "tutorialId") Long tutorialId,
		      @Valid @RequestBody CommentDTO commentRequest) {
		
		Comment comment = commentService.insertComment(tutorialId, modelMapper.map(commentRequest, Comment.class));
		
		if(comment==null) {
			Comment commentR = new Comment();
			commentR.setContent("NO SE INSERTO EL COMENTARIO - BAD REQUEST");
		    return new ResponseEntity<>(commentR, HttpStatus.BAD_REQUEST);

		}
		

	    return new ResponseEntity<>(comment, HttpStatus.CREATED);
		
	}
	

	
}
