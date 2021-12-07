package com.codegym.dish_management.service.impl;

import com.codegym.dish_management.entity.food.Food;
import com.codegym.dish_management.repository.IFoodRepository;
import com.codegym.dish_management.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class IFoodServiceImpl implements IFoodService {

    @Autowired
    private IFoodRepository foodRepository;

    @Override
    public Page<Food> viewAllFoodAndDrink(Pageable pageable, String name, Double price, Integer id) {
        return foodRepository.findAllFood(pageable, name, price, id);
    }
}
