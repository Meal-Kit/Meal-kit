package com.js.mealkitecommerce.app.model.VO.Cart;

import com.js.mealkitecommerce.app.entity.Kit;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartItemResponseVO {
    private Kit kit;
    private int count;
}
