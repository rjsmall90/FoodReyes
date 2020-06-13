package com.foodreyes.menu.carts;

import com.foodreyes.menu.core.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "shopping_cart")
class CartSelection extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shopping_cart_id")
    private Long cartId;

    @Column(name = "customer_id")
    private UUID customerId;

    @Column(name = "order_number")
    private Long orderNumber;

    @Column(name = "item_id")
    private Long itemId;
}
