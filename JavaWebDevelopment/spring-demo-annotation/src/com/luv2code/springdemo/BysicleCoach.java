package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BysicleCoach implements Coach {
	

	public FortuneService fortuneService;
	
	@Autowired
	public  BysicleCoach(@Qualifier("randomFortuneService") FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	@Override
	public String getDailyWorkout() {
		return "Work hard 5 house";
	}

}
