package com.codegym.dish_management.controller;

import com.codegym.dish_management.entity.food.Food;
import com.codegym.dish_management.service.ICategoryService;
import com.codegym.dish_management.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/food")
public class FoodController {

    @Autowired
    private IFoodService foodService;

    @GetMapping("/list")
    public ResponseEntity<Page<Food>> viewAllFood(@PageableDefault(value = 5, sort = "food_id", direction = Sort.Direction.ASC)
                                                          Pageable pageable,
                                                  @RequestParam(value = "name", required = false) String name,
                                                  @RequestParam(value = "price", required = false) Double price,
                                                  @RequestParam(value = "id", required = false) Integer id) {
        Page<Food> foodList = foodService.viewAllFoodAndDrink(pageable, name, price, id);
        if (!foodList.isEmpty()) {
            return new ResponseEntity<>(foodList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
