package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.luv2code.springdemo")
public class NewConfig {
	
	@Bean
	public FortuneService sadFortuneService() {
		return new NewFortune();
	}
	
	@Bean
	public Coach basbollCoach() {
		return new BasbollCoach(sadFortuneService());
	}

}
