package com.js.mealkitecommerce.app.service;

import com.js.mealkitecommerce.app.constants.ExceptionConstants;
import com.js.mealkitecommerce.app.entity.Customer;
import com.js.mealkitecommerce.app.entity.Kit;
import com.js.mealkitecommerce.app.entity.cart.Cart;
import com.js.mealkitecommerce.app.entity.cart.CartItem;
import com.js.mealkitecommerce.app.exception.NotEnoughKitException;
import com.js.mealkitecommerce.app.model.VO.Cart.CartItemResponseVO;
import com.js.mealkitecommerce.app.repository.CartItemRepository;
import com.js.mealkitecommerce.app.repository.CartRepository;
import com.js.mealkitecommerce.app.repository.KitRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final KitRepository kitRepository;

    public Cart findByCustomer(Customer customer) {
        return cartRepository.findByCustomer(customer);
    }

    public void addCart(Customer customer, Kit kit) {
        if (kit.getQuantity() > 0) {
            kit.setQuantity(kit.getQuantity() - 1);
            kitRepository.save(kit);
        } else {
            throw new NotEnoughKitException(ExceptionConstants.NOT_ENOUGH_KIT);
        }

        Cart cart = cartRepository.findByCustomer(customer);

        if (cart == null) {
            cart = Cart.createCart(customer);
            cartRepository.save(cart);
        }

        CartItem cartItem = cartItemRepository.findByCartIdAndKitId(cart.getId(), kit.getId());

        if (cartItem == null) {
            cartItem = CartItem.createCartItem(cart, kit, 1);
            cartItemRepository.save(cartItem);
            cart.setCount(cart.getCount() + 1);
        } else {
            System.out.println("적용");
            cartItem.addCount(1);
        }

        cartRepository.save(cart);
        cartItemRepository.save(cartItem);
    }

    public List<CartItemResponseVO> findCartItemByCart(Cart cart) {
        List<CartItem> cartItems = cartItemRepository.findAll();
        List<CartItemResponseVO> userItems = new ArrayList<>();

        for (CartItem cartItem : cartItems) {
            if (cartItem.getCart() == cart) {
                CartItemResponseVO vo =
                        CartItemResponseVO.builder().kit(cartItem.getKit()).count(cartItem.getCount()).build();
                userItems.add(vo);
            }
        }

        return userItems;
    }
}
