package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	private FortuneService  fortuneService;
	@Value("${foo.email}")
	private String email;
	@Value("${foo.name}")
	private String name;
	
	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	@Override
	public String getDailyWorkout() {// TODO Auto-generated method stub
		return "Swim five hourse along";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}
	public String getEmail() {
		return email;
	}
	public String getName() {
		return name;
	}
}
