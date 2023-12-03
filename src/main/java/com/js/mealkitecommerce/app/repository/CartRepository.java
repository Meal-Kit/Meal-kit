package com.js.mealkitecommerce.app.repository;

import com.js.mealkitecommerce.app.entity.Customer;
import com.js.mealkitecommerce.app.entity.cart.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByCustomer(Customer customer);
}
