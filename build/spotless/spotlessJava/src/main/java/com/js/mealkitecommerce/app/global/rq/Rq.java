package com.js.mealkitecommerce.app.global.rq;

import com.js.mealkitecommerce.app.entity.Customer;
import com.js.mealkitecommerce.app.model.context.CustomerContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@Slf4j
@RequestScope
public class Rq {
    private final HttpServletRequest req;
    private final HttpServletResponse resp;
    private final CustomerContext customerContext;
    @Getter private final Customer customer;

    public Rq(HttpServletRequest req, HttpServletResponse resp) {
        this.req = req;
        this.resp = resp;

        // 현재 로그인한 회원의 인증정보를 가져옴
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.getPrincipal() instanceof CustomerContext) {
            this.customerContext = (CustomerContext) authentication.getPrincipal();
            this.customer = customerContext.getCustomer();
        } else {
            this.customerContext = null;
            this.customer = null;
        }
    }
}
