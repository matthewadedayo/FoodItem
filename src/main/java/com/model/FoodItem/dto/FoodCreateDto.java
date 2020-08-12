package com.model.FoodItem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Adedayo
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodCreateDto {
    
    private String foodName;
    private double price;
}