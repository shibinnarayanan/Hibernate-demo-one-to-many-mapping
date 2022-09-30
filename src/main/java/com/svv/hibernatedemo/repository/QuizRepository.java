package com.svv.hibernatedemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.svv.hibernatedemo.entity.Question;

public interface QuizRepository extends JpaRepository<Question,Long>{
	
	Question findByid(long id);

}
