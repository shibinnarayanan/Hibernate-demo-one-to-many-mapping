package com.svv.hibernatedemo.service;

import java.util.List;

import com.svv.hibernatedemo.entity.Question;


public interface QuizServiceInterface {
	
	Question saveQuestion(Question qstns);
	
	Question getQuestionById(long id);
	
	void deleteQuestionById(long id);
	
	List<Question> getAllQuestions();

}
