package com.webapplication.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.webapplication.entities.User;

@SessionAttributes("usersSession")
@Controller
public class HomePageController {
	
	@RequestMapping(value = "/usershomepage", method = RequestMethod.GET)
	public ModelAndView userHomePage(HttpSession httpSession){
		
		ModelAndView userInfo = new ModelAndView("sitePages/homePage");
		
		User newses = (User) httpSession.getAttribute("usersSession");
		
		userInfo.addObject("usersInfor", newses);
		
		
		return userInfo;
		
	}

}
