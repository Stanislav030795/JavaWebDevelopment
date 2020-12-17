package com.luv2code.springdemo;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {
 
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("BeanLifeCucle-applicationContext.xml");	
		TrackCoach theCoach1 = context.getBean("myCoach",TrackCoach.class);
		System.out.println(theCoach1.getDailyFortunes());
		System.out.println(theCoach1.getDailyWorkout());
		context.close();

	}

}
