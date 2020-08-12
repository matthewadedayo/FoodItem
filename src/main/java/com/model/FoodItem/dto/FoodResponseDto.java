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
public class FoodResponseDto {
    
    private String foodName;
    private double price;
}