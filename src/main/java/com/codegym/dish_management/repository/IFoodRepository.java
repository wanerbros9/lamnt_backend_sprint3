package com.codegym.dish_management.repository;

import com.codegym.dish_management.entity.food.Food;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface IFoodRepository extends JpaRepository<Food, Integer> {

    //create food
    @Modifying
    @Query(value = "insert into `food` (delete_flag, food_name, food_image, food_price, food_description, category_id)" +
            "values (0,?1,?2,?3,?4,?5)", nativeQuery = true)
    void createFood(String food_name, String food_image, Double food_price, String food_description, Integer category_id);

    //update food
    @Modifying
    @Query(value = "update `food` set food_name = ?1, food_image = ?2, food_price = ?3, food_description = ?4 " +
            "category_id = ?5 where food_id = ?6", nativeQuery = true)
    void updateFood(String food_name, String food_image, Double food_price, String food_description, Integer category_id, Integer food_id);

    //detail food
    @Query(value = "select food_id, delete_flag, fad_name, fad_image, fad_price, food_description, category_id from `food` where delete_Flag = false and fad_id = ?1",
            nativeQuery = true)
    Food detailFood(@Param("id") Integer id);

    //findAll
    @Query(value = "select food_id, delete_flag, food_description, food_image, food_name, food_price, category_id " +
            "FROM food where delete_flag = false " +
            "and (?1 is null or food_name like %?1%)" +
            "and (?2 is null or food_price = ?2)" +
            "and (?3 is null or category_id = ?3)",
            countQuery = "select food_id, delete_flag, food_description, food_image, food_name, food_price, category_id " +
                    "FROM food where delete_flag = false " +
                    "and (?1 is null or food_name like %?1%)" +
                    "and (?2 is null or food_price = ?2)" +
                    "and (?3 is null or category_id = ?3)",
            nativeQuery = true)
    Page<Food> findAllFood(Pageable pageable,@Param("foodName") String foodName,@Param("foodPrice") Double foodPrice,@Param("categoryId") Integer categoryId);

    @Query(value = "select food_id, delete_flag, food_description, food_image, food_name, food_price, category_id " +
            "FROM food where delete_flag = false " +
            "and (?1 is null or food_name like %?1%)" +
            "and (?2 is null or food_price = ?2)",
            countQuery = "select food_id, delete_flag, food_description, food_image, food_name, food_price, category_id " +
                    "FROM food where delete_flag = false " +
                    "and (?1 is null or food_name like %?1%)" +
                    "and (?2 is null or food_price = ?2)",
            nativeQuery = true)
    Page<Food> findAllFoodNoId(Pageable pageable,@Param("foodName") String foodName,@Param("foodPrice") Double foodPrice);
}
