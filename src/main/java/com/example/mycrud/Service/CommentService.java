package com.example.mycrud.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mycrud.Model.Comment;
import com.example.mycrud.Repository.ICommentRepository;
import com.example.mycrud.Repository.ITutorialRepository;

@Service
public class CommentService {
	
	@Autowired
	ICommentRepository commentRepo;
	
	@Autowired
	ITutorialRepository tutoRepo;
	
	
	public List<Comment> getCommentsTuto(Long tutorialId) {
		
	    if (!tutoRepo.existsById(tutorialId)) {
		     // throw new ResourceNotFoundException("Not found Tutorial with id = " + tutorialId);
	    	return new ArrayList<Comment>();
		 }

		    List<Comment> comments = commentRepo.findByTutorialId(tutorialId);
		    return comments;
	}
	
	
	public Comment insertComment(Long tutorialId,Comment commentRequest) {
		
		 Comment comment = tutoRepo.findById(tutorialId).map(tutorial -> {
			      commentRequest.setTutorial(tutorial);
			      return commentRepo.save(commentRequest);
			    }).orElse(null); //orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + tutorialId));

		   
		  return comment;
		   

	}

}
