package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);	
		//TennisCoach theCoach = context.getBean("theSillyCoach",TennisCoach.class);
		/*PingPongCoach theCoach1 = context.getBean("pingPongCoach",PingPongCoach.class);
		BysicleCoach theCoach2 = context.getBean("bysicleCoach",BysicleCoach.class);
		System.out.println(theCoach1.getDailyFortune());
		System.out.println(theCoach1.getDailyWorkout());
		System.out.println(theCoach2.getDailyFortune());
		System.out.println(theCoach2.getDailyWorkout());*/
		SwimCoach theCoach = context.getBean("swimCoach",SwimCoach.class);
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getEmail());
		System.out.println(theCoach.getName());
		context.close();
	}

}
