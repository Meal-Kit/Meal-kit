package com.js.mealkitecommerce.app.entity.cart;

import com.js.mealkitecommerce.app.entity.BaseEntity;
import com.js.mealkitecommerce.app.entity.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Cart extends BaseEntity {
    @OneToMany(fetch = FetchType.EAGER)
    private List<CartItem> cartItems = new ArrayList<>();

    @OneToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Customer customer;

    private int count;

    public static Cart createCart(Customer customer) {
        Cart cart = new Cart();
        cart.customer = customer;
        cart.count = 0;

        return cart;
    }
}
