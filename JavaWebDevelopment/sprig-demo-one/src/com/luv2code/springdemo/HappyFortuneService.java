package com.luv2code.springdemo;

public class HappyFortuneService implements FortuneService {
	
	String []fortunes= {"Fortune1","Fortune2","Fortune3"};
	int a = (int) ( Math.random() * 3 );

	public String getFortune() {
		return fortunes[a];
	}

}
