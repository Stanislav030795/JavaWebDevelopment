package com.luv2code.springdemo;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {
 
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");	
		CricketCoach theCoach = context.getBean("myCoach4",CricketCoach.class);
		System.out.println(theCoach.getDailyFortunes());
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getEmail());
		System.out.println(theCoach.getTeam()); 
		context.close();

	}

}
