package com.codegym.dish_management.entity.account;

import com.codegym.dish_management.entity.customer.Customer;
import com.codegym.dish_management.entity.order.Orders;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;
    private String accountUsername;
    private String accountPassword;
    private String email;
    private boolean isActive;
    private boolean isNotBlock;
    private boolean isDelete;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "account_role", joinColumns = @JoinColumn(name = "account_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @JsonBackReference(value = "customer_account")
    @OneToOne(mappedBy = "account")
    private Customer customer;

    @OneToMany(mappedBy = "account")
    private List<Orders> ordersList;
}
