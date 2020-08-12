package com.model.FoodItem.service.impl;

import com.model.FoodItem.dto.FoodCreateDto;
import com.model.FoodItem.dto.FoodResponseDto;
import com.model.FoodItem.dto.ServerResponse;
import com.food.FoodModel.Food.FoodItem;
import com.model.FoodItem.repository.FoodItemRepository;
import com.model.FoodItem.service.FoodItemService;
import com.model.FoodItem.utility.ServerResponseType;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Transactional
@Service
public class FoodItemServiceImpl implements FoodItemService{
	
	@Autowired
	private FoodItemRepository foodItemRepository;
        
        
	@Override
	public FoodItem findById(Integer foodId) {
		
		Optional<FoodItem> foodItem = foodItemRepository.findById(foodId);
                        if (foodItem.isPresent())
                             return foodItem.get();
                        else
                          return new FoodItem();
	}
                   	
                  
    @Override
    public ServerResponse create(FoodCreateDto request) {
        
        ServerResponse response = new ServerResponse();
        FoodItem foodItem = null;
             
        String foodName = request.getFoodName() != null ? request.getFoodName() : request.getFoodName();
        double price = request.getPrice() != 0 ? request.getPrice() : request.getPrice();
        
         //Validations
                if (foodName == null || foodName.isEmpty()) {
                   response.setData("");
                   response.setMessage("Please provide Food Name");
                   response.setSuccess(false);
                   response.setStatus(ServerResponseType.FAILED);

            return response;
            }
                 if (price == 0 ) {
                   response.setData("");
                   response.setMessage("Please provide food price");
                   response.setSuccess(false);
                   response.setStatus(ServerResponseType.FAILED);

            return response;
            }
                
            try {
             
			foodItem = new FoodItem();	
                         
                        foodItem.setFoodName(foodName);
                        foodItem.setPrice(request.getPrice());                    
			
			foodItemRepository.save(foodItem);
			
			FoodResponseDto dto = new FoodResponseDto();
			dto.setFoodName(foodName);
			dto.setPrice(request.getPrice());
			
			
			response.setData(dto);
                        response.setMessage("FoodItem created successfully");
                        response.setSuccess(true);
                        response.setStatus(ServerResponseType.OK);

		
		}catch(Exception e) {
			 response.setData("");
	          response.setMessage("Failed to create FoodItem");
	          response.setSuccess(false);
	          response.setStatus(ServerResponseType.FAILED);
	          e.printStackTrace();	
		}
			
		return response;
    }  
    
    
    @Override
    public ServerResponse getFoodByName(String foodName) {
        ServerResponse response =  new ServerResponse();
		
		//Validating to ensure that Food Item code is inputed
		/*if(foodName == null || foodName.isEmpty()) {
                    
                    response.setData("");
                    response.setMessage("Please provide Food Item Name");
                    response.setSuccess(false);
                    response.setStatus(ServerResponseType.FAILED);
                    return response;
		}
		
		try {
			//Confirming inputed order number exists
			FoodItem food = foodItemRepository
			
		     if (food == null) {
			response.setData("");
                        response.setMessage("Food Item with Name " + foodName + " does not exist");
                        response.setSuccess(false);
                        response.setStatus(ServerResponseType.OK);
                        return response;
                                                
			}
	
			//Server response if Food Item with number exists 
			FoodResponseDto dto = new FoodResponseDto();
			dto.setFoodName(foodName);
			dto.setPrice(0);
			
			
			response.setData(dto);
                        response.setMessage("Food Item printed successfully");
                        response.setSuccess(true);
                        response.setStatus(ServerResponseType.OK);
			
			
		}catch(Exception e) {
			response.setData("");
            response.setMessage("Something went wrong");
            response.setSuccess(false);
            response.setStatus(ServerResponseType.INTERNAL_SERVER_ERROR);
            e.printStackTrace();
            return response;
		}*/
		
		return response;
    }

    @Override
    public ServerResponse getAllFood() {
       ServerResponse response = new ServerResponse();
		
		try {
			List<FoodItem> foodItem = foodItemRepository.findAll();
			
			if (foodItem.size() < 1) {
				response.setData("");
				response.setMessage("FoodItem list is empty");
				response.setSuccess(false);
				response.setStatus(ServerResponseType.NO_CONTENT);
				
				return response;
			}
			
			response.setData(foodItem);
			response.setMessage("Data fetched successfully");
			response.setSuccess(true);
			response.setStatus(ServerResponseType.OK);
		} catch (Exception e){
			
			response.setData("");
			response.setMessage("Failed to fetch data");
			response.setSuccess(false);
			response.setStatus(ServerResponseType.FAILED);
			return response;
		}
		
		return response;
	
    }


}
