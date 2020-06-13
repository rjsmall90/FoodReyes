package com.foodreyes.menu.carts;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
class CartSelectionDTO {
    private Long cartId;
    private UUID customerId;
    private Long orderNumber;
    private Long itemId;
    private String name;
    private String imageUrl;
    private BigDecimal price;
}
