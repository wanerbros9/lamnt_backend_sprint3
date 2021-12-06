package com.codegym.dish_management.jwt_token;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseToken {
    private String token;
    private String username;
    private List<String> roles;
}
