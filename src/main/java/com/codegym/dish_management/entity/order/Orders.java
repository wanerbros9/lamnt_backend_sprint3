package com.codegym.dish_management.entity.order;

import com.codegym.dish_management.entity.account.Account;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ordersId;
    private String dateOrders;

    @OneToMany(mappedBy = "orders")
    @JsonBackReference("orders-food-orders")
    private List<OrderDetail> ordersList;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
