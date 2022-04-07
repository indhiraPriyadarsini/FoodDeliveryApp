package com.example.FoodDeliveryApplication.Services;

import java.util.ArrayList;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.FoodDeliveryApplication.Repository.RepoFoodDeliveryApp;
import com.example.FoodDeliveryApplication.Model.ModelFoodDeliveryApp;
import com.example.FoodDeliveryApplication.Model.UserDTO;

@Service
public class MyUserDetailsService implements UserDetailsService {


	@Autowired
	private RepoFoodDeliveryApp repo;

	@Autowired
	@Lazy
	private PasswordEncoder bcryptEncoder;

	@Override

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		ModelFoodDeliveryApp user = repo.findByUsername(username);
		if (user == null) {
			System.out.println("");
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}

	public ModelFoodDeliveryApp save(UserDTO user) {
		ModelFoodDeliveryApp newUser = new ModelFoodDeliveryApp();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setEmail(user.getEmail());
		return repo.save(newUser);
	}

}