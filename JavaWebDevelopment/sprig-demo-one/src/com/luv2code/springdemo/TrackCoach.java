package com.luv2code.springdemo;

public class TrackCoach implements Coach {

private FortuneService fortuneSurvice;
	
	public TrackCoach(FortuneService fortuneSurvice) {
		this.fortuneSurvice=fortuneSurvice;
	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "TruckTraining";
	}

	@Override
	public String getDailyFortunes() {
		// TODO Auto-generated method stub
		return  "____"+fortuneSurvice.getFortune();
	}
	
	public void doMyStart() {
		System.out.println("Start");
	}

	public void doMyEnd() {
		System.out.println("End");
	}
}
