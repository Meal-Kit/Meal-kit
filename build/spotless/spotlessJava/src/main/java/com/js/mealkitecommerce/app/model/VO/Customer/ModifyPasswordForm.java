package com.js.mealkitecommerce.app.model.VO.Customer;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ModifyPasswordForm {
    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;

    @NotBlank(message = "변경할 비밀번호를 입력해주세요.")
    private String modifyPassword;

    @NotBlank(message = "비밀번호 확인은 필수항목입니다.")
    private String modifyPasswordConfirm;
}
