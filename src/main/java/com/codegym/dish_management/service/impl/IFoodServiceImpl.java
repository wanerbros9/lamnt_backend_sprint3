package com.codegym.dish_management.service.impl;

import com.codegym.dish_management.entity.food.Food;
import com.codegym.dish_management.repository.IFoodRepository;
import com.codegym.dish_management.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IFoodServiceImpl implements IFoodService {

    @Autowired
    private IFoodRepository foodRepository;

    @Override
    public Page<Food> viewAllFoodAndDrink(Pageable pageable, String foodName, Double foodPrice, Integer categoryId) {
        return foodRepository.findAllFood(pageable, foodName, foodPrice, categoryId);
    }

    @Override
    public Page<Food> viewAllFoodAndDrinkNoId(Pageable pageable, String foodName, Double foodPrice) {
        return foodRepository.findAllFoodNoId(pageable, foodName, foodPrice);
    }

    @Override
    public List<Food> topFiveNewFood() {
        return foodRepository.topFiveNewFood();
    }
}
