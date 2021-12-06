package com.codegym.dish_management.repository;

import com.codegym.dish_management.entity.food.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface IFoodRepository extends JpaRepository<Food, Integer> {

    //create food
    @Modifying
    @Query(value = "insert into `food` (delete_flag, food_name, food_image, food_price)" +
            "values (0,?1,?2,?3)", nativeQuery = true)
    void createFood(String food_name, String food_image, Double food_price);

    //update food
    @Modifying
    @Query(value = "update `food` set food_name = ?1, food_image = ?2, food_price =?3 " +
            "category_id = ?4 where food_id = ?5", nativeQuery = true)
    void updateFood(String food_name, String food_image, Double food_price, Integer category_id, Integer food_id);

    //detail food
    @Query(value = "select fad_id, delete_flag, fad_name, fad_image, fad_price, category_id from `food` where delete_Flag = false and fad_id = ?1",
            nativeQuery = true)
    Food detailFood(@Param("id") Integer id);
}
