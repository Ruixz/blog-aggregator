package com.rui.blog.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rui.blog.entity.User;
import com.rui.blog.service.UserService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute("user")
	private User constructUser() {
		return new User();
	}

	@RequestMapping
	public String showRegister(){
		return "user-register";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String doRegister(@Valid @ModelAttribute("user") User user, BindingResult result){
		if(result.hasErrors()){
			return "user-register";
		}
		userService.save(user);
		return "redirect:/register.html?success=true";
	}
	
}
