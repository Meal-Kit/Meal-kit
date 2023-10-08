package com.js.mealkitecommerce.app.model.common;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseData {
    private String result;
    private String statusCode;
    private Object data;
}
