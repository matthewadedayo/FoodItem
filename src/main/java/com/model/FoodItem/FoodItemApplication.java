package com.model.FoodItem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//@EntityScan ({"com.food.FoodModel.Food" })
@EntityScan(basePackages = "com.food.FoodModel.Food")
public class FoodItemApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodItemApplication.class, args);
	}

}
