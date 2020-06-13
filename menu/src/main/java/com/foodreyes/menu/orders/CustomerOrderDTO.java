package com.foodreyes.menu.orders;

import com.foodreyes.menu.carts.CartSelectionDTO;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOrderDTO {
    Long orderNumber;
    UUID customerId;
    String username;
    String customerName;
    String customerEmailAddress;
    BigDecimal orderTotal;
    List<CartSelectionDTO> cartSelectionDTOS;
}
