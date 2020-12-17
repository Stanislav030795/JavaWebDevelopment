package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppHome {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(NewConfig.class);	
		BasbollCoach theCoach = context.getBean("basbollCoach",BasbollCoach.class);
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theCoach.getDailyWorkout());
		context.close();

	}

}
