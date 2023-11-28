package com.js.mealkitecommerce.app.model.VO.Kit;

import com.js.mealkitecommerce.app.constants.type.PackingType;
import com.js.mealkitecommerce.app.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateKitRequestVO {
    private String title;
    private String category;
    private int price;
    private int quantity;
    private String how;
    private int discount;
    private PackingType packingType;
}