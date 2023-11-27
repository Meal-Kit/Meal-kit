package com.js.mealkitecommerce.app.model.VO.Customer;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class FindUsernameVO {
    @NotBlank(message = "이메일을 입력해주세요.")
    @Email
    private String email;
}
