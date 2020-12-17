package com.luv2code.springdemo;

public class CricketCoach implements Coach  {
	
	private FortuneService fortuneSurvice;
	private String email;
	private String team;

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTeam(String team) {
		this.team = team;
	}
	
	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

	public CricketCoach() {
	System.out.println("Inside method Cricket");			
	}

	public void setFortuneSurvice(FortuneService fortuneSurvice) {
		this.fortuneSurvice = fortuneSurvice;
	}
	@Override
	public String getDailyWorkout() {
		return "Cricket OK!!!";
	}

	@Override
	public String getDailyFortunes() {
		return fortuneSurvice.getFortune();
	}

}
