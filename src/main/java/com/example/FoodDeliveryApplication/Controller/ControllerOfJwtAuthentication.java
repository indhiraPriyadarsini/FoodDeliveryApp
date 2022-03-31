package com.example.FoodDeliveryApplication.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class ControllerOfJwtAuthentication {
	@RestController
	public class HelloWorldController {

		@RequestMapping("/hello" )
		public String firstPage() {
			return "Hello World";
		}

	}}
//	 @PostMapping("/authenticate")
//	    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
//	        try {
//	            authenticationManager.authenticate(
//	                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
//	            );
//	        } catch (Exception ex) {
//	            throw new Exception("inavalid username/password");
//	        }
//	        return jwtUtil.generateToken(authRequest.getUserName());
//	    }
//	}


