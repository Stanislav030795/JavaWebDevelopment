package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");	
		//TennisCoach theCoach = context.getBean("theSillyCoach",TennisCoach.class);
		PingPongCoach theCoach1 = context.getBean("pingPongCoach",PingPongCoach.class);
		BysicleCoach theCoach2 = context.getBean("bysicleCoach",BysicleCoach.class);
		System.out.println(theCoach1.getDailyFortune());
		System.out.println(theCoach1.getDailyWorkout());
		System.out.println(theCoach2.getDailyFortune());
		System.out.println(theCoach2.getDailyWorkout());
		context.close();
	}

}
