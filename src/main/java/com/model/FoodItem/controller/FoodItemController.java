package com.model.FoodItem.controller;

import com.food.FoodModel.Food.FoodItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.FoodItem.dto.ServerResponse;
import com.model.FoodItem.dto.FoodCreateDto;
import com.model.FoodItem.utility.ServerResponseType;
import com.model.FoodItem.service.FoodItemService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping(value = "/foods", produces = "application/json")
@Api(tags = "Food Management", description = "Endpoint")
public class FoodItemController {
	
	
	@Autowired
	FoodItemService foodItemService;
	
	private HttpHeaders responseHeaders = new HttpHeaders();
	
	
	@ApiOperation(value = "Food creation", response = ServerResponse.class)
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> createCustomer(@RequestBody FoodCreateDto request){
		
		
		ServerResponse response = new ServerResponse();
		
		try {
			
			response = foodItemService.create(request);
		 
		} catch (Exception e) {
			response.setData("An error occured" + e.getMessage());
                        response.setMessage("An error occured");
                        response.setSuccess(false);
                        response.setStatus(ServerResponseType.FAILED);
            
		}
		
		return new ResponseEntity<ServerResponse>(response, responseHeaders, ServerResponse.getStatus(response.getStatus()));
	}
	
	
	
	@ApiOperation(value = "List all food", response = ServerResponse.class)
       @RequestMapping(value = "/all", method = RequestMethod.GET)
       @ResponseBody
       public ResponseEntity<?> getAllFoods(@RequestHeader("Authorization")  String authorization){
		
		ServerResponse response = new ServerResponse();
		
		try {
			
			response = foodItemService.getAllFood();
		
		} catch (Exception e) {
			response.setData("User account verification error" + e.getMessage());
			response.setMessage("User account verification error");
	        response.setSuccess(false);
            response.setStatus(ServerResponseType.FAILED);
		}
		
		return new ResponseEntity<ServerResponse>(response, responseHeaders, ServerResponse.getStatus(response.getStatus()));

	}

       
       
       @RequestMapping(value = "/{id}", method = RequestMethod.GET)
       public FoodItem getfoodItem(@PathVariable(value = "id") Integer foodId){        
            	FoodItem foodItem = foodItemService.findById(foodId);
                log.info("Food Item Available");
			return foodItem;
       }      
}
