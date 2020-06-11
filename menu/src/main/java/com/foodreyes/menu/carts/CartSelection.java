package com.foodreyes.menu.carts;

import com.foodreyes.menu.core.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    @Column(name = "customer_id")
    private UUID customerId;

    @Column(name = "order_number")
    private Long orderNumber;

    @Column(name = "item_id")
    private Long itemId;
}
