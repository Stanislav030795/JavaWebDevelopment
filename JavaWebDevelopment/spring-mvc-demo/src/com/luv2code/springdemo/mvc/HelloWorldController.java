package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Hello")
public class HelloWorldController {

	@RequestMapping("/ShowForm")
	public String showForm() {
		return "helloworld-form" ;
	}
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld" ;
	}
	
	@RequestMapping("/processFormTwo")
	public String letShowDude(HttpServletRequest request, Model model) {
		
		String theName = request.getParameter("studentName");
		theName = theName.toUpperCase();
		String result = "Yo!"+theName;
		model.addAttribute("message",result);
		return "helloworld" ;
	}
	
	
	@RequestMapping("/processFormThree")
	public String processFormThree(@RequestParam("studentName") String theName, Model model) {
		theName = theName.toUpperCase();
		String result = "Hey My Friend!"+theName;
		model.addAttribute("message",result);
		return "helloworld" ;
	}
}
