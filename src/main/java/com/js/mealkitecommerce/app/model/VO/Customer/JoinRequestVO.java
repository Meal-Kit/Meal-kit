package com.js.mealkitecommerce.app.model.VO.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JoinRequestVO {
    private String name;
    private String username;
    private String password;
    private String passwordConfirm;
    private String email;
    private String address;
    private String address2;
    private String tel;
}
