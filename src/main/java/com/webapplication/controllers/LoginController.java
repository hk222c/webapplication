package com.webapplication.controllers;

import java.util.Date;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.webapplication.classes.LoginForm;
import com.webapplication.entities.User;
import com.webapplication.serviceInterface.UserService;
import com.webapplication.valdations.LoginValidation;

@SessionAttributes("usersSession")
@Controller
public class LoginController {
	
	//Logger log = Logger.getLogger(LoginController.class.getName());
	
	@Autowired
	private UserService loginServiceImp;
	
	@Autowired
	private LoginValidation loginfovalid;
	
	@InitBinder
	private void initBinder(WebDataBinder webbinder){
		webbinder.setValidator(loginfovalid);
	}
	
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView loginPage(){
		
		ModelAndView homeLogin = new ModelAndView("sitePages/mainPage");
		homeLogin.addObject("loginInfo", new LoginForm());
		
		return homeLogin;
		
	}
	
	
	@RequestMapping(value = "/homePage", method = RequestMethod.POST)
	public String userLogin(@ModelAttribute("loginInfo") @Valid LoginForm loginInfo, BindingResult results){		
		
		if(results.hasErrors()){			
			
			
			return "sitePages/mainPage";
		}
		
		ModelAndView userhomePage = new ModelAndView("sitePages/homePage");
		User loginUsersInfo = loginServiceImp.getUserInfo(loginInfo.getUserName());
		
		//userhomePage.addObject("usersInfo", loginUsersInfo);
		userhomePage.addObject("todaysdate", new Date());
		userhomePage.addObject("usersSession", loginUsersInfo);	

		
		return "redirect:/usershomepage";
		
	}

}
