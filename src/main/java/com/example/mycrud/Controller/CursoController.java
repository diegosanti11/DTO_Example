package com.example.mycrud.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.mycrud.Model.Curso;


import com.example.mycrud.Repository.ICursoRepository;

@RestController
public class CursoController {
	
	@Autowired
	ICursoRepository cursoRepo;
	
	 @GetMapping("/cursos")
	  public ResponseEntity<List<Curso>> getAllCursos(@RequestParam(required = false) String title) {
	    
		 List<Curso> cursos = new ArrayList<Curso>();

	    if (title == null)
	    	cursoRepo.findAll().forEach(cursos::add);
	    else
	    	cursoRepo.findByTitleContaining(title).forEach(cursos::add);

	    if (cursos.isEmpty()) {
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	    return new ResponseEntity<>(cursos, HttpStatus.OK);
	  }
	 
	 
	 @PostMapping("/cursos")
	  public ResponseEntity<Curso> createCurso(@RequestBody Curso curso) {
		 Curso _curso = cursoRepo.save(new Curso(curso.getTitle(), curso.getDescription(), true));
	    return new ResponseEntity<>(_curso, HttpStatus.CREATED);
	  }
	 
	 @PutMapping("/cursos/{id}")
	  public ResponseEntity<Curso> updateCurso(@PathVariable("id") long id, @RequestBody Curso curso) {
		 
		 Curso _curso = cursoRepo.findById(id)
	        .orElseThrow();
		

		 _curso.setTitle(curso.getTitle());
		 _curso.setDescription(curso.getDescription());
		 _curso.setPublished(curso.isPublished());
	    
	    return new ResponseEntity<>(cursoRepo.save(_curso), HttpStatus.OK);
	  }

}
