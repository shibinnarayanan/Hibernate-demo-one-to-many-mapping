package com.svv.hibernatedemo.entity;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table
public class Question {
	
	public Question()
	{
		
	}
	
	
	
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getQuestion() {
		return question;
	}



	public void setQuestion(String question) {
		this.question = question;
	}



	public String getAnswer() {
		return answer;
	}



	public void setAnswer(String answer) {
		this.answer = answer;
	}



	public List<Options> getOptions() {
		return options;
	}



	public void setOptions(List<Options> options) {
		this.options = options;
	}



	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", answer=" + answer + ", options=" + options + "]";
	}



	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String question;
	private String answer;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "qid" ,referencedColumnName = "id")
	List<Options> options = new ArrayList<>();

	public Question(long id, String question, String answer, List<Options> options) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.options = options;
	}


}
