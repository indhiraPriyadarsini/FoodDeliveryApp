package com.example.FoodDeliveryApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.authentication.AuthenticationManager;

import com.example.FoodDeliveryApplication.Model.AuthenticationRequest;
import com.example.FoodDeliveryApplication.Model.AuthenticationResponse;
import com.example.FoodDeliveryApplication.Model.ModelFoodDeliveryApp;
import com.example.FoodDeliveryApplication.Model.UserDTO;
import com.example.FoodDeliveryApplication.Repository.RepoFoodDeliveryApp;
import com.example.FoodDeliveryApplication.SecurityConfigurer.JwtTokenUtil;
import com.example.FoodDeliveryApplication.Services.MyUserDetailsService;

@Controller
public class ControllerOfFoodDeliveryApp {

	@Autowired
	RepoFoodDeliveryApp repo;
	
	@Autowired 
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
//	@RequestMapping("/signin")
//	public String signin() {
//		return "signin.jsp";
//	}
//	
//	@RequestMapping("/login")
//	public String login() {
//		return "login.jsp";
//	}	
//	
//	@RequestMapping("/adduser")
//	public String addUser(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("password") String password, Model model) {
//		ModelFoodDeliveryApp userDetails = new ModelFoodDeliveryApp();
//		userDetails.setName(name);
//		userDetails.setEmail(email);
//		userDetails.setPassword(password);
//		repo.save(userDetails);
//		//model.addAttribute("registration successful","continue to login");
//		return "login.jsp";
//	}
		
		
	
	@RequestMapping( value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)throws Exception{	
			try {

				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
						authenticationRequest.getUsername(), authenticationRequest.getPassword()));
			} catch (BadCredentialsException e) {
				throw new Exception("Incorrect Username or Password");
			}

			final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());

			final String jwt = jwtTokenUtil.generateToken(userDetails);

			return ResponseEntity.ok(new AuthenticationResponse(jwt));
		}

		@RequestMapping( value= "/signin" , method = RequestMethod.POST)
		public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
			return ResponseEntity.ok(myUserDetailsService.save(user));
		}

	}



