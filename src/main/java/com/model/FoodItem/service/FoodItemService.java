package com.model.FoodItem.service;

import com.model.FoodItem.dto.FoodCreateDto;
import com.model.FoodItem.dto.ServerResponse;
import com.food.FoodModel.Food.FoodItem;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adedayo
 */

@Service
public interface FoodItemService  {
    
    public FoodItem findById(Integer foodId);
    
    public ServerResponse getFoodByName(String foodName);
    
    public ServerResponse getAllFood();
    
    public ServerResponse create(FoodCreateDto request);
}
