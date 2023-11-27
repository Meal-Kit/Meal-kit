package com.js.mealkitecommerce.app.controller;

import com.js.mealkitecommerce.app.entity.Customer;
import com.js.mealkitecommerce.app.exception.*;
import com.js.mealkitecommerce.app.global.email.service.EmailService;
import com.js.mealkitecommerce.app.global.util.ResponseUtil;
import com.js.mealkitecommerce.app.model.VO.Customer.*;
import com.js.mealkitecommerce.app.model.common.ResponseData;
import com.js.mealkitecommerce.app.model.context.CustomerContext;
import com.js.mealkitecommerce.app.service.CustomerService;
import com.js.mealkitecommerce.app.service.common.JwtService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/customer")
public class CustomerController {
    private final CustomerService customerService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    // 회원가입 -> 자동로그인(Header에 자동 포함)
    @PostMapping(
            value = "/join",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<ResponseData> join(@RequestBody JoinRequestVO joinForm) {
        LoginVO login;
        try {
            Customer customer = customerService.join(joinForm);
            login = new LoginVO(customer.getUsername(), customer.getPassword());
        } catch (EmailDuplicatedException e) {
            throw new EmailDuplicatedException("EMAIL_DUPLICATED_ERROR");
        } catch (UserIdDuplicatedException e) {
            throw new UserIdDuplicatedException("ID_DUPLICATED_ERROR");
        } catch (Exception e) {
            throw new SignUpException("SIGN_UP_ERROR");
        }

        return login(login);
    }

    // 로그인 로직 -> JWT Token 자동 생성 후 헤더에 입력(Ahthentication)
    @PostMapping(
            value = "/login",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<ResponseData> login(@RequestBody LoginVO request) {
        if (request.isNotValid()) {
            return ResponseUtil.failResponseEntity();
        }

        Customer customer = customerService.findByUsername(request.getUsername()).orElse(null);

        if (customer == null) {
            return ResponseUtil.failResponseEntity();
        }

        // accessToken 생성
        String accessToken = jwtService.generateAccessKey(customer);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authentication", accessToken);

        return ResponseUtil.successResponse(customer, headers);
    }

    // 프로필 조회(JWT 입력해주면 바로 조회됨, 다른거 안넣어도 자동으로 출력)
    @PostMapping(
            value = "/profile",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<ResponseData> retrieveCustomerProfile(
            @AuthenticationPrincipal CustomerContext context) {
        Customer customer =
                customerService
                        .findByUsername(context.getUsername())
                        .orElseThrow(() -> new DataNotFoundException("Customer Not Found"));

        return ResponseUtil.successResponse(customer);
    }

    // 회원 정보 수정
    @PostMapping(
            value = "/modify",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ResponseData> modifyCustomerData(
            @AuthenticationPrincipal CustomerContext context, @RequestBody ModifyCustomerVO modifyForm) {
        try {
            customerService.modify(context, modifyForm);
        } catch (EmailDuplicatedException e) {
            throw new EmailDuplicatedException("EMAIL_DUPLICATED_ERROR");
        } catch (UserIdDuplicatedException e) {
            throw new UserIdDuplicatedException("ID_DUPLICATED_ERROR");
        }

        return ResponseUtil.successResponse();
    }

    // 비밀번호 수정
    @PostMapping(
            value = "/modifyPassword",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ResponseData> modifyCustomerPassword(
            @AuthenticationPrincipal CustomerContext context,
            @RequestBody ModifyPasswordVO modifyPasswordForm) {
        Customer loginedCustomer =
                customerService
                        .findByUsername(context.getUsername())
                        .orElseThrow(() -> new DataNotFoundException("Customer Not Found"));

        if (!passwordEncoder.matches(modifyPasswordForm.getPassword(), loginedCustomer.getPassword())) {
            throw new NotMatchPresentPassword("현재 비밀번호가 틀립니다.");
        }

        try {
            customerService.modifyPassword(loginedCustomer, modifyPasswordForm.getModifyPassword());
        } catch (DataNotFoundException e) {
            throw new DataNotFoundException("DATA_NOT_FOUND");
        } catch (NotMatchPresentPassword e) {
            throw new NotMatchPresentPassword("NOT_MATCH_PRESENT_PASSWORD");
        }

        return ResponseUtil.successResponse();
    }

    // 회원 아이디 찾기
    @PostMapping(
            value = "/findUsername",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ResponseData> retrieveUsername(@RequestBody FindUsernameVO findUsernameVo) {
        Customer customer =
                customerService
                        .findByEmail(findUsernameVo.getEmail())
                        .orElseThrow(() -> new DataNotFoundException("등록된 아이디가 존재하지 않습니다."));

        return ResponseUtil.successResponse(customer);
    }

    // 비밀번호 찾기
    @PostMapping(
            value = "/findPassword",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ResponseData> retrievePassword(@RequestBody FindPasswordVO findPasswordVo) {
        Customer customer =
                customerService
                        .findByUsernameAndEmail(findPasswordVo.getUsername(), findPasswordVo.getEmail())
                        .orElseThrow(() -> new DataNotFoundException("등록된 사용자가 없습니다."));

        String newPassword = RandomStringUtils.randomAlphanumeric(10);

        try {
            customerService.setNewPassword(customer, newPassword);
        } catch (DataNotFoundException e) {
            throw new DataNotFoundException("DATA_NOT_FOUND");
        }

        emailService.sendSimpleMessage(customer, newPassword);

        return ResponseUtil.successResponse();
    }
}
