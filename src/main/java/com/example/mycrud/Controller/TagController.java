package com.example.mycrud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.mycrud.Model.Tag;

import java.util.ArrayList;
import java.util.List;

import com.example.mycrud.Repository.ICursoRepository;
import com.example.mycrud.Repository.ITagRepository;

@RestController
public class TagController {
	
	@Autowired
	ITagRepository tagRepository;
	
	@Autowired
	ICursoRepository cursoRepo;
	
	@GetMapping("/tags")
	  public ResponseEntity<List<Tag>> getAllTags() {
	    List<Tag> tags = new ArrayList<Tag>();

	    tagRepository.findAll().forEach(tags::add);

	    if (tags.isEmpty()) {
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	    return new ResponseEntity<>(tags, HttpStatus.OK);
	  }
	
	
	
	
	 @PostMapping("/cursos/{cursoId}/tags")
	  public ResponseEntity<Tag> addTag(@PathVariable(value = "cursoId") Long cursoId, @RequestBody Tag tagRequest) {
		 
	    Tag tag = cursoRepo.findById(cursoId).map(curso -> {
	      long tagId = tagRequest.getId();
	      
	      System.out.println("tagId---->"+tagId);
	      
	      // tag is existed
	      if (tagId != 0L) {
	        Tag _tag = tagRepository.findById(tagId)
	                .orElse(null);
	        
	        if(_tag==null) {
	        }
	        
	        curso.addTag(_tag);
	        cursoRepo.save(curso);
	        return _tag;
	      }
	      
	      // add and create new Tag
	      curso.addTag(tagRequest);
	      return tagRepository.save(tagRequest);
	      
	    }).orElse(null);

	    return new ResponseEntity<>(tag, HttpStatus.CREATED);
	  }

}
