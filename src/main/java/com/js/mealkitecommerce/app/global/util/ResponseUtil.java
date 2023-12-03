package com.js.mealkitecommerce.app.global.util;

import com.js.mealkitecommerce.app.constants.CommonConstants;
import com.js.mealkitecommerce.app.constants.StatusConstants;
import com.js.mealkitecommerce.app.model.common.ResponseData;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@UtilityClass
public class ResponseUtil {
    public static ResponseEntity<ResponseData> successResponse(Object data) {
        return successResponseEntity(data);
    }

    public static ResponseEntity<ResponseData> successResponse() {
        return successResponseEntity(null);
    }

    public static ResponseEntity<ResponseData> successResponse(Object data, HttpHeaders headers) {
        return successResponseEntity(data, headers);
    }

    private static ResponseEntity<ResponseData> successResponseEntity(Object data) {
        return new ResponseEntity<>(
                ResponseData.builder()
                        .result(CommonConstants.YES)
                        .statusCode(StatusConstants.SUCCESS)
                        .data(data)
                        .build(),
                HttpStatus.OK);
    }

    private static ResponseEntity<ResponseData> successResponseEntity(
            Object data, HttpHeaders header) {
        return new ResponseEntity<>(
                ResponseData.builder()
                        .result(CommonConstants.YES)
                        .statusCode(StatusConstants.SUCCESS)
                        .data(data)
                        .build(),
                header,
                HttpStatus.OK);
    }

    public static ResponseEntity<ResponseData> failResponseEntity() {
        return new ResponseEntity<>(
                ResponseData.builder()
                        .result(CommonConstants.NO)
                        .statusCode(StatusConstants.FAIL)
                        .data(null)
                        .build(),
                HttpStatus.EXPECTATION_FAILED);
    }
}
