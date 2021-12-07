package com.codegym.dish_management.service;

import com.codegym.dish_management.entity.food.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAllCategory();
}
