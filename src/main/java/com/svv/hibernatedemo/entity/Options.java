package com.svv.hibernatedemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Options {
	
	public Options()
	{
		
	}

	public Options(String option) {
		super();
		this.option = option;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String option;
	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}


}
