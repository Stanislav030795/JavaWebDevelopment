package com.luv2code.springdemo;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
 
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("BeanScope-applicationContext.xml");	
		TrackCoach theCoach1 = context.getBean("myCoach",TrackCoach.class);
		TrackCoach theCoach2 = context.getBean("myCoach",TrackCoach.class);
		System.out.println(theCoach1.getDailyFortunes());
		System.out.println(theCoach1.getDailyWorkout());
		System.out.println(theCoach2.getDailyFortunes());
		System.out.println(theCoach2.getDailyWorkout());
		boolean b = theCoach1==theCoach2;
		System.out.println(b);
		System.out.println(theCoach1+" "+ theCoach2);
		context.close();

	}

}
