package com.codegym.dish_management.service;

import com.codegym.dish_management.entity.food.Food;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFoodService {
    Page<Food> viewAllFoodAndDrink(Pageable pageable, String foodName, Double foodPrice, Integer categoryId);

    Page<Food> viewAllFoodAndDrinkNoId(Pageable pageable, String foodName, Double foodPrice);

    List<Food> topFiveNewFood();
}
