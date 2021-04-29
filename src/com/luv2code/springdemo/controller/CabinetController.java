package com.luv2code.springdemo.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.entity.User;
import com.luv2code.springdemo.service.UserService;

@Controller
@RequestMapping("/cabinet")
public class CabinetController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpSession session;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping
	public String showCabinet(Model theModel) {
		
		if(session.getAttribute("usersId")==null) {
			return "redirect:/user/login";
		}
		
		User theUser = userService.getUserById((int)session.getAttribute("usersId"));
		theModel.addAttribute("user", theUser);
		return "cabinet/index";
	}
	

	@GetMapping("/edit")
	public String showEdit(Model theModel) {
		
			if(session.getAttribute("usersId")==null) {
			return "redirect:/user/login";
		}
		theModel.addAttribute("save", false);
		
		User theUser = userService.getUserById((int)session.getAttribute("usersId"));
		theModel.addAttribute("user", theUser);

		return "cabinet/edit";
	}
	
	@PostMapping("/edit/save")
	public String editSave(Model theModel,@Valid @ModelAttribute("user") User user,
			BindingResult theBindingResult) {
		
		if(session.getAttribute("usersId")==null) {
			return "redirect:/user/login";
		}
		
		if (theBindingResult.hasErrors()) {
			theModel.addAttribute("save", false);
		}
		else {
			userService.saveUser(user);
			theModel.addAttribute("save", true);
		}

		return "cabinet/edit";
	}

}
