package com.luv2code.springdemo;

public class TennisCoach implements Coach {

private FortuneService fortuneSurvice;
	
	public TennisCoach(FortuneService fortuneSurvice) {
		this.fortuneSurvice=fortuneSurvice;
	}
	
	public TennisCoach() {
		
	}
	
	
	
	@Override
	public String getDailyWorkout() {
		return "Tennis";
	}

	@Override
	public String getDailyFortunes() {
		// TODO Auto-generated method stub
		return  "HI!!! "+fortuneSurvice.getFortune();
	}

	
}
