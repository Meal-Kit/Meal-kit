package com.js.mealkitecommerce.app.service.common;

import com.js.mealkitecommerce.app.entity.Customer;
import com.js.mealkitecommerce.app.global.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtService {
    private final TokenProvider tokenProvider;

    public String generateAccessKey(Customer customer) {
        return tokenProvider.generateAccessToken(customer.getAccessTokenClaims());
    }
}
