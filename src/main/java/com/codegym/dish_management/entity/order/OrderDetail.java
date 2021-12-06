package com.codegym.dish_management.entity.order;

import com.codegym.dish_management.entity.food.Food;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long orderFoodId;
    private Integer quantityFood;

    @ManyToOne
    @JoinColumn(name = "orders_id", referencedColumnName = "ordersId")
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "food_id", referencedColumnName = "foodId")
    private Food food;
}
