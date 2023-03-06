package com.nagarro.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
	
//	logout from current session
	@RequestMapping("logout")
	public String logout(HttpSession session) {

		session.setAttribute("user", null);
		session.setAttribute("username", null);
		return "login";
	}
}
