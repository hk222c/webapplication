package com.webapplication.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.webapplication.classes.RegistrationForm;
import com.webapplication.enmus.Roles;
import com.webapplication.serviceInterface.UserService;
import com.webapplication.valdations.RegistrationValdation;

@Controller
public class RegistrationController {
	
	@Autowired
	private RegistrationValdation registerValid;
	
	@Autowired
	private UserService registerServiceImp;
	
	@InitBinder
	private void initBinder(WebDataBinder webbinder){
		webbinder.setValidator(registerValid);
	}
	
	
	@RequestMapping(value = "/registrationPage", method = RequestMethod.GET)
	public ModelAndView registerPage(){
		
		ModelAndView registrePage = new ModelAndView("sitePages/registrationPage");
		registrePage.addObject("registreInfo", new RegistrationForm());
		
		return registrePage;
	}
	
	
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public String userRegisterd(@ModelAttribute("registreInfo") @Valid RegistrationForm registreInfo, BindingResult errors){
		
		if(errors.hasErrors()){
			return "sitePages/registrationPage";
		}
		
		registreInfo.setUserRole(Roles.SIMPLEUSER);
		registerServiceImp.saveUser(registreInfo);
		
		return "sitePages/homePage";
	}

}
