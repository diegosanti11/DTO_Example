package com.example.mycrud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.mycrud.Model.Story2;

@Repository
public interface StoryRepository extends JpaRepository<Story2, String> {
	
}