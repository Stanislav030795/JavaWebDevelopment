package com.luv2code.springdemo;

public class BaseballCoach implements Coach {
	
	private FortuneService fortuneSurvice;
	
	public BaseballCoach(FortuneService fortuneSurvice) {
		this.fortuneSurvice=fortuneSurvice;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Batting practice";
	}

	@Override
	public String getDailyFortunes() {
		// TODO Auto-generated method stub
		return  fortuneSurvice.getFortune();
	}

}
