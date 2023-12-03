package com.js.mealkitecommerce.app.controller;

import com.js.mealkitecommerce.app.entity.Kit;
import com.js.mealkitecommerce.app.entity.cart.Cart;
import com.js.mealkitecommerce.app.global.util.ResponseUtil;
import com.js.mealkitecommerce.app.model.VO.Cart.CartItemResponseVO;
import com.js.mealkitecommerce.app.model.VO.Cart.CartListResponseVO;
import com.js.mealkitecommerce.app.model.common.ResponseData;
import com.js.mealkitecommerce.app.model.context.CustomerContext;
import com.js.mealkitecommerce.app.service.CartService;
import com.js.mealkitecommerce.app.service.KitService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/cart")
public class CartController {
    private final CartService cartService;
    private final KitService kitService;

    @GetMapping(
            value = "/list",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<ResponseData> cartList(
            @AuthenticationPrincipal CustomerContext customerContext) {
        Cart cart = cartService.findByCustomer(customerContext.getCustomer());
        List<CartItemResponseVO> cartItems = cartService.findCartItemByCart(cart);
        CartListResponseVO responseVO = new CartListResponseVO();
        responseVO.setCartItems(cartItems);
        int totalPrice = 0;
        for (CartItemResponseVO cartItem : cartItems) {
            totalPrice +=
                    cartItem.getKit().getPrice()
                            * (100 - cartItem.getKit().getDiscount())
                            / 100
                            * cartItem.getCount();
        }
        responseVO.setTotalPrice(totalPrice);

        return ResponseUtil.successResponse(responseVO);
    }

    @PostMapping(
            value = "addCart/{kitId}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<ResponseData> addCart(
            @AuthenticationPrincipal CustomerContext customerContext, @PathVariable Long kitId) {
        Kit kit = kitService.findById(kitId);

        cartService.addCart(customerContext.getCustomer(), kit);

        return ResponseUtil.successResponse("넣어짐!!");
    }
}
