package com.luv2code.springdemo;

public class BasbollCoach implements Coach {

	private FortuneService  fortuneService;
	
	public BasbollCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Baseboll OK!!! Workout!!!";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
