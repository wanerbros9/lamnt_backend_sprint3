package com.codegym.dish_management.service.impl;

import com.codegym.dish_management.entity.food.Category;
import com.codegym.dish_management.repository.ICategoryRepository;
import com.codegym.dish_management.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAllCategory();
    }
}
