package com.example.mycrud.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mycrud.Model.Tutorial;
import com.example.mycrud.Repository.ITutorialRepository;

@Service
public class TutorialService {
	
	@Autowired
	ITutorialRepository tutoRepo;
	
	public List<Tutorial> getAllTutos(){
		
		return tutoRepo.findAll();
		
	}
	
	public Tutorial createmodiTutorial(Tutorial tuto) {
		return tutoRepo.save(tuto);
	}
	
	

}
