package com.example.mycrud.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mycrud.Model.Tutorial;
import com.example.mycrud.Repository.ITutorialRepository;
import com.example.mycrud.Service.TutorialService;
import com.example.mycrud.dto.TutorialDTO;

@RestController
public class TutorialController {
	
	@Autowired
	TutorialService tutoService;
	
	@Autowired
	ITutorialRepository tutorialRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	  @GetMapping("/tutorials")
	  public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title) {
		  
	    List<Tutorial> tutorials = new ArrayList<Tutorial>();

	    if (title == null)
	      tutorialRepository.findAll().forEach(tutorials::add);
	    else
	      tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);

	    if (tutorials.isEmpty()) {
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	    return new ResponseEntity<>(tutorials, HttpStatus.OK);
	  }
	  
	  
	  
	
	@GetMapping("/tutorial")
	public List<Tutorial> getallTutos(){
		
		return tutoService.getAllTutos();
		
	}
	
	@PostMapping("/tutorial")
	public Tutorial insertTuto(@Valid @RequestBody TutorialDTO tuto) {

		return tutoService.createmodiTutorial(modelMapper.map(tuto, Tutorial.class));
		
	}

}
