package com.example.mycrud.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mycrud.Model.Comment;

@Repository
public interface ICommentRepository extends JpaRepository<Comment, Long>{
	
	  List<Comment> findByTutorialId(Long postId);
	  
	  @Transactional
	  void deleteByTutorialId(long tutorialId);

}
