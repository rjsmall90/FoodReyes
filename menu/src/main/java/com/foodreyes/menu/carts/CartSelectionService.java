package com.foodreyes.menu.carts;

import com.foodreyes.menu.items.ItemRepository;
import com.foodreyes.menu.orders.CustomerOrder;
import com.foodreyes.menu.orders.CustomerOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CartSelectionService {

    private final CartSelectionRepository cartSelectionRepository;
    private final CustomerOrderRepository customerOrderRepository;
    private final ItemRepository itemRepository;

    CartSelection addItemToCart(CartSelection cartSelection) {
        CustomerOrder customerOrder;

        if (cartSelectionRepository.findCustomerOrderCountByCustomerId(cartSelection.getCustomerId()) == null) {
            customerOrder = new CustomerOrder();
            customerOrder.setCustomerId(cartSelection.getCustomerId());
        } else {
            customerOrder = customerOrderRepository.findNotCompletedCustomerOrderByCustomerId(cartSelection.getCustomerId());
        }

        List<CartSelection> cartSelections = findAllCartSelectionsForCustomer(cartSelection.getCustomerId());

        customerOrder.setOrderTotal(getCurrentOrderTotal(cartSelections));

        cartSelection.setOrderNumber(customerOrder.getOrderId());
        return cartSelectionRepository.save(cartSelection);
    }

    private List<CartSelection> findAllCartSelectionsForCustomer(UUID customerId) {
        return cartSelectionRepository.findAllCartSelectionsByCustomerId(customerId);
    }

    private BigDecimal getCurrentOrderTotal(List<CartSelection> cartSelections) {
        BigDecimal currentTotal = BigDecimal.ZERO;
        for (CartSelection cartSelection : cartSelections) {
            BigDecimal itemPrice = itemRepository.findItemByItemId(cartSelection.getItemId()).getPrice();
            currentTotal.add(itemPrice);
        }
        return currentTotal;
    }
}
