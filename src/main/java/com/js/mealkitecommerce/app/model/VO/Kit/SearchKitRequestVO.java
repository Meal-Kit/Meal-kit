package com.js.mealkitecommerce.app.model.VO.Kit;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchKitRequestVO {
    private String type;
    private String keyword;
}
