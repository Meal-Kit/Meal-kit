package com.js.mealkitecommerce.app.service.common;

import com.js.mealkitecommerce.app.entity.Customer;
import com.js.mealkitecommerce.app.global.jwt.TokenProvider;
import com.js.mealkitecommerce.app.global.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class JwtService {
    private final TokenProvider tokenProvider;

    public String generateAccessKey(Customer customer) {
        Map<String, Object> tokenClaim = Util.mapOf(
                "username", customer.getUsername(),
                "name", customer.getName(),
                "email", customer.getEmail(),
                "phoneNum", customer.getPhoneNum(),
                "age", customer.getAge(),
                "sex", customer.getSex(),
                "address", customer.getAddress(),
                "addressDetail", customer.getAddressDetail(),
                "postNum", customer.getPostNum()
        );
        return tokenProvider.generateAccessToken(tokenClaim);
    }
}
