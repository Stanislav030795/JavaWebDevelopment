package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnorarionBeanScopeApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");	
		Coach theCoach1 = context.getBean("tennisCoach",Coach.class);
		Coach theCoach2 = context.getBean("tennisCoach",Coach.class);
		
		boolean b = theCoach1==theCoach2;
		System.out.println(b);
		
		System.out.println(theCoach1+" "+theCoach2);
		context.close();
		
	}

}
