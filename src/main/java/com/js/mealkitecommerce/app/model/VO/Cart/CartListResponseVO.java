package com.js.mealkitecommerce.app.model.VO.Cart;

import java.util.List;
import lombok.Data;

@Data
public class CartListResponseVO {
    private List<CartItemResponseVO> cartItems;
    private int totalPrice;
}
