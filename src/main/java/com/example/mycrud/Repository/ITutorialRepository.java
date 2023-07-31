package com.example.mycrud.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mycrud.Model.Tutorial;

@Repository
public interface ITutorialRepository extends JpaRepository<Tutorial, Long>{
	
	List<Tutorial> findByPublished(boolean published);

	List<Tutorial> findByTitleContaining(String title);

}
