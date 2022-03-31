package com.example.FoodDeliveryApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.FoodDeliveryApplication.Model.ModelFoodDeliveryApp;
import com.example.FoodDeliveryApplication.Repository.RepoFoodDeliveryApp;

@Controller
public class ControllerOfFoodDeliveryApp {

	@Autowired
	RepoFoodDeliveryApp repo;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	@RequestMapping("/signin")
	public String signin() {
		return "signin.jsp";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login.jsp";
	}	
	
	@RequestMapping("/adduser")
	public String addUser(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("password") String password, Model model) {
		ModelFoodDeliveryApp userDetails = new ModelFoodDeliveryApp();
		userDetails.setName(name);
		userDetails.setEmail(email);
		userDetails.setPassword(password);
		repo.save(userDetails);
		//model.addAttribute("registration successful","continue to login");
		return "login.jsp";
	}
		
		
	
	@RequestMapping("/check")
	public String checkUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
	ModelFoodDeliveryApp userEmail = null;
	ModelFoodDeliveryApp userPassword = null;
	try {
		 userEmail = repo.findByEmail(email);
		 userPassword = repo.findByPassword(password);
	}
	catch(Exception e) {
		System.out.println( "User not found");
	}
		if(userEmail != null && userPassword != null) {
			model.addAttribute("email",email);
			return "welcome.jsp";
		}
		else {
			model.addAttribute("error","user not found");
			return "signIn.jsp";
		}
	}			         
}


