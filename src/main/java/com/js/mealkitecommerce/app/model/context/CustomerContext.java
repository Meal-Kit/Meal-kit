package com.js.mealkitecommerce.app.model.context;

import com.js.mealkitecommerce.app.constants.type.SexType;
import com.js.mealkitecommerce.app.entity.Customer;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Getter
public class CustomerContext extends User {
    private final Long id;
    private final LocalDateTime createDate;
    private final LocalDateTime modifyDate;
    private final String username;
    private final String name;
    private final String email;
    private final String phoneNum;
    private final String age;
    private final SexType sex;
    private final String address;
    private final String addressDetail;
    private final String postNum;

    public CustomerContext(Customer customer, List<GrantedAuthority> authorities) {
        super(customer.getUsername(), customer.getPassword(), authorities);
        this.id = customer.getId();
        this.createDate = customer.getCreateDate();
        this.modifyDate = customer.getModifyDate();
        this.username = customer.getUsername();
        this.name = customer.getName();
        this.email = customer.getEmail();
        this.phoneNum = customer.getPhoneNum();
        this.age = customer.getAge();
        this.sex = customer.getSex();
        this.address = customer.getAddress();
        this.addressDetail = customer.getAddressDetail();
        this.postNum = customer.getPostNum();
    }

    public Customer getCustomer() {
        return Customer.builder()
                .id(id)
                .createDate(createDate)
                .modifyDate(modifyDate)
                .username(username)
                .name(name)
                .email(email)
                .phoneNum(phoneNum)
                .age(age)
                .sex(sex)
                .address(address)
                .addressDetail(addressDetail)
                .postNum(postNum)
                .build();
    }
}
