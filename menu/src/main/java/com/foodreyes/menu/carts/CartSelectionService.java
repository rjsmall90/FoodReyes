package com.foodreyes.menu.carts;

import com.foodreyes.menu.items.ItemRepository;
import com.foodreyes.menu.orders.CustomerOrder;
import com.foodreyes.menu.orders.CustomerOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartSelectionService {

    private final CartSelectionRepository cartSelectionRepository;
    private final CustomerOrderRepository customerOrderRepository;
    private final ItemRepository itemRepository;

    CartSelection addItemToCart(CartSelection cartSelection) {
        CustomerOrder customerOrder;

        if (cartSelectionRepository.findCustomerOrderCountByCustomerId(cartSelection.getCustomerId()) == 0) {
            System.out.println("Please not here");
            customerOrder = new CustomerOrder();
            customerOrder.setCustomerId(cartSelection.getCustomerId());
        } else {
            customerOrder = customerOrderRepository.findNotCompletedCustomerOrderByCustomerId(cartSelection.getCustomerId());
        }

        List<CartSelection> cartSelections = findAllCartSelectionsForCustomer(cartSelection);

        customerOrder.setOrderTotal(getCurrentOrderTotal(cartSelections));
        customerOrderRepository.save(customerOrder);

        cartSelection.setOrderNumber(customerOrder.getOrderNumber());
        return cartSelectionRepository.save(cartSelection);
    }

    private List<CartSelection> findAllCartSelectionsForCustomer(CartSelection cartSelection) {
        List<CartSelection> cartSelections = cartSelectionRepository.findAllCartSelectionsByCustomerId(cartSelection.getCustomerId());
        cartSelections.add(cartSelection);
        return cartSelections;
    }

    private BigDecimal getCurrentOrderTotal(List<CartSelection> cartSelections) {
        List<BigDecimal> itemPrices = new ArrayList<>();
        for (CartSelection cartSelection : cartSelections) {
            BigDecimal itemPrice = itemRepository.findItemByItemId(cartSelection.getItemId()).getPrice();
            itemPrices.add(itemPrice);
        }
        BigDecimal currentTotal = itemPrices.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(currentTotal);
        return currentTotal;
    }
}
