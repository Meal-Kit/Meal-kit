package com.js.mealkitecommerce.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.js.mealkitecommerce.app.constants.type.SexType;
import com.js.mealkitecommerce.app.global.util.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Customer extends BaseEntity {
    @Size(min = 5, max = 25, message = "사용자 ID는 5자 이상 25자 이하로 적어주세요.")
    @Column(unique = true)
    private String username;
    @JsonIgnore
    private String password;
    private String name;
    private String email;
    private String phoneNum;
    private String age;
    private SexType sex;
    private String address;
    private String addressDetail;
    private String postNum;

    public Collection<? extends GrantedAuthority> getUserRole() {
        List<GrantedAuthority> userRole = new ArrayList<>();
        userRole.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        return userRole;
    }

    public Map<String, Object> getAccessTokenClaims() {
        return Util.mapOf(
                "username", getUsername(),
                "name", getName(),
                "email", getEmail(),
                "phoneNum", getPhoneNum(),
                "age", getAge(),
                "sex", getSex(),
                "address", getAddress(),
                "addressDetail", getAddressDetail(),
                "postNum", getPostNum()
        );
    }
}
