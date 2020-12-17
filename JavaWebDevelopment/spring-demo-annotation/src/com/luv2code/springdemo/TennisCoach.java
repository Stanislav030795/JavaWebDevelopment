package com.luv2code.springdemo;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("theSillyCoach")
@Component
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	public FortuneService fortuneService;
	
	@PostConstruct
	public void doMyStart() {
		System.out.println("Init");
	}
	
	@PreDestroy
	public void doMyEnd() {
		System.out.println("End");
	}

	/*@Autowired
	 * public TennisCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}*/
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	/*@Autowired
	public void doSomeCrazyStuff(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}*/

	@Override
	public String getDailyWorkout() {
		return "Practice a backhand volley";
	}
}
