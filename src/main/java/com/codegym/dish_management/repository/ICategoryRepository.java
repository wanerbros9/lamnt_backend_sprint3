package com.codegym.dish_management.repository;

import com.codegym.dish_management.entity.food.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {

    //findAll Category
    @Query(value = "select  category_id, category_name from `category`", nativeQuery = true)
    List<Category> findAllCategory();
}
