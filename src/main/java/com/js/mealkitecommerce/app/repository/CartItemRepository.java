package com.js.mealkitecommerce.app.repository;

import com.js.mealkitecommerce.app.entity.cart.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem findByCartIdAndKitId(Long cartId, Long kitId);
}
