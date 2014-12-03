package com.rui.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rui.blog.entity.User;
import com.rui.blog.service.UserService;

@Controller
public class AjaxController {

	@Autowired
	private UserService userService;

	@RequestMapping(value="ajaxSearchUser.htm", method=RequestMethod.GET)
	public String ajaxSearchUser(@RequestParam("userName") String userName, Model model) {
		User user = userService.findOne(userName);
		model.addAttribute("ajaxUser", user);
		return "ajaxresult";
	}
}
