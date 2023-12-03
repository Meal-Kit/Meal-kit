package com.js.mealkitecommerce.app.model.VO.Kit;

import com.js.mealkitecommerce.app.constants.type.PackingType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ModifyKitRequestVO {
    private String title;
    private String category;
    private int price;
    private int quantity;
    private String how;
    private int discount;
    private PackingType packingType;
}
