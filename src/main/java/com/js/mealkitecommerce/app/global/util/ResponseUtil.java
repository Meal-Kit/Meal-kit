package com.js.mealkitecommerce.app.global.util;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.js.mealkitecommerce.app.entity.Customer;
import com.js.mealkitecommerce.app.model.common.ResponseData;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@UtilityClass
public class ResponseUtil {
    public static ResponseEntity<ResponseData> successResponse(Object data) {
        return new ResponseEntity<>(
                ResponseData.builder()
                        .result("Y")
                        .statusCode("Success")
                        .data(data)
                        .build(),
                HttpStatus.OK);
    }

    private static ResponseEntity<ResponseData> failResponse() {
        return new ResponseEntity<>(
                ResponseData.builder()
                        .result("N")
                        .statusCode("Fail")
                        .data(null)
                        .build(),
                HttpStatus.EXPECTATION_FAILED);
    }
}