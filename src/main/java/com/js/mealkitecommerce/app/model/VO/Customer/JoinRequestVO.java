package com.js.mealkitecommerce.app.model.VO.Customer;

import com.js.mealkitecommerce.app.constants.type.SexType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JoinRequestVO {
    private String username;
    private String password;
    private String name;
    private String email;
    private String phoneNum;
    private String age;
    private SexType sex;
    private String address;
    private String addressDetail;
    private String postNum;
}
