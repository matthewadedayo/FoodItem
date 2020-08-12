package com.model.FoodItem.repository;

import com.food.FoodModel.Food.FoodItem;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Adedayo
 
 */
@Repository
public interface FoodItemRepository extends CrudRepository<FoodItem, Integer> {
    
    public FoodItem findById(int foodId);
    
    //public FoodItem findByName(String foodName);
    
    List <FoodItem> findAll();
    
}
