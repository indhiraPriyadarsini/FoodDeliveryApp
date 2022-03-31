package com.example.FoodDeliveryApplication.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.FoodDeliveryApplication.Model.ModelFoodDeliveryApp;
@Repository
public interface RepoFoodDeliveryApp extends CrudRepository<ModelFoodDeliveryApp, Integer>{
	ModelFoodDeliveryApp findByEmail(String email);
	ModelFoodDeliveryApp findByPassword(String password);

}
