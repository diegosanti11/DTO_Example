package com.example.mycrud.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mycrud.Model.Curso;

@Repository
public interface ICursoRepository extends JpaRepository<Curso, Long>{
	
	//List<Curso> findTutorialsByTagsId(Long tagId);
	
	List<Curso> findByTitleContaining(String title);


}
