package com.js.mealkitecommerce.app.entity.cart;

import com.js.mealkitecommerce.app.entity.BaseEntity;
import com.js.mealkitecommerce.app.entity.Kit;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class CartItem extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    private Cart cart;

    @ManyToOne(fetch = FetchType.EAGER)
    private Kit kit;

    private int count;

    public static CartItem createCartItem(Cart cart, Kit kit, int count) {
        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setKit(kit);
        cartItem.setCount(count);

        return cartItem;
    }

    public void addCount(int count) {
        this.count += count;
    }
}
