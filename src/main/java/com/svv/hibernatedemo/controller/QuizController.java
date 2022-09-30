package com.svv.hibernatedemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.svv.hibernatedemo.entity.Answer;
import com.svv.hibernatedemo.entity.Options;
import com.svv.hibernatedemo.entity.Question;
import com.svv.hibernatedemo.service.OptionServiceInterface;
import com.svv.hibernatedemo.service.QuizServiceInterface;

@RestController
public class QuizController {
	
	@Autowired
	QuizServiceInterface quizService;
	
	@Autowired
	OptionServiceInterface optService;

    
	@PostMapping("/save")
	ResponseEntity<?> saveQuestionAndOptions(@RequestBody Question qstn){
		
		try {
			Question questionSaved = quizService.saveQuestion(qstn);
			return new ResponseEntity<>(questionSaved, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("error +"+e.getMessage(), HttpStatus.BAD_REQUEST);

		}
		
	}
	
	@GetMapping("/all")
	ResponseEntity<?> getAllQuestions()
	{
		try {
			List<Question> allQstn = quizService.getAllQuestions();
			return new ResponseEntity<>(allQstn, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("error -> "+e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/answer/{id}/{option}")
	ResponseEntity<?> validateAnswer(@PathVariable(value = "id") Long id,@PathVariable(value = "option") String option)
	{
		try {
			
			boolean result = false;
			String answer = null;
			
			Question qstn = quizService.getQuestionById(id);
			answer = qstn.getAnswer();
			if(option.equals(answer))
			{
				result = true;
			}
			Answer ans = new Answer();
			ans.setResult(result);
			ans.setAnswer(answer);
			
			
			return new ResponseEntity<>(ans, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("error -> "+e.getMessage(), HttpStatus.BAD_REQUEST);
		} 
		
	}
	
	
}
