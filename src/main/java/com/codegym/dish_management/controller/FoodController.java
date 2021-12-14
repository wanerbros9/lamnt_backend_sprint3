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

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/food")
public class FoodController {

    @Autowired
    private IFoodService foodService;

    @GetMapping("/list")
    public ResponseEntity<Page<Food>> viewAllFood(@PageableDefault(value = 6) Pageable pageable,
                                                  @RequestParam(required = false) String foodName,
                                                  @RequestParam(required = false) Double foodPrice,
                                                  @RequestParam(required = false) Integer categoryId) {
        Page<Food> foodList = foodService.viewAllFoodAndDrink(pageable, foodName, foodPrice, categoryId);
        if (!foodList.isEmpty()) {
            return new ResponseEntity<>(foodList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/list-no-id")
    public ResponseEntity<Page<Food>> viewAllFood(@PageableDefault(value = 6) Pageable pageable,
                                                  @RequestParam(required = false) String foodName,
                                                  @RequestParam(required = false) Double foodPrice) {
        Page<Food> foodList = foodService.viewAllFoodAndDrinkNoId(pageable, foodName, foodPrice);
        if (!foodList.isEmpty()) {
            return new ResponseEntity<>(foodList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/top-five")
    public ResponseEntity<List<Food>> topFiveFood() {
        List<Food> foodList = foodService.topFiveNewFood();
        if (foodList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foodList, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Food> detailFood(@PathVariable Integer id) {
        Food food = foodService.detailFood(id);
        if (food != null) {
            return new ResponseEntity<>(food, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
