package com.example.mycrud.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mycrud.Model.Tag;

@Repository
public interface ITagRepository extends JpaRepository<Tag, Long> {
	  List<Tag> findTagsByCursosId(Long tutorialId);
}