package com.svv.hibernatedemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svv.hibernatedemo.entity.Question;
import com.svv.hibernatedemo.repository.QuizRepository;

@Service
public class QuizService implements QuizServiceInterface{
	
	@Autowired
	QuizRepository qRepo;

	@Override
	public Question saveQuestion(Question qstns) {
		return qRepo.save(qstns);
	}

	public Question getQuestionById(long id) {
		return qRepo.findByid(id);
	}
	@Override
	public void deleteQuestionById(long id) {
		qRepo.deleteById(id);
	}

	@Override
	public List<Question> getAllQuestions() {
		return qRepo.findAll();
	}

}
