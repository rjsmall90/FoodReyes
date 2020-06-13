package com.foodreyes.menu.carts;

import com.foodreyes.menu.items.ItemRepository;
import com.foodreyes.menu.orders.CustomerOrder;
import com.foodreyes.menu.orders.CustomerOrderRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class CartSelectionService {

    private final CartSelectionRepository cartSelectionRepository;
    private final CustomerOrderRepository customerOrderRepository;
    private final ItemRepository itemRepository;

    List<CartSelectionDTO> findAllCartSelectionsForCustomer(UUID customerId) {
        return cartSelectionRepository.findDTOByCustomerId(customerId);
    }

    CartSelection addItemToCart(CartSelection cartSelection) {
        CustomerOrder customerOrder = findOrCreateNewCustomerOrder(cartSelection.getCustomerId());

        List<CartSelection> cartSelections = findAllCartSelectionsForCustomerForCustomerOrderTotal(cartSelection);

        handleCustomerOrder(customerOrder, cartSelections);

        cartSelection.setOrderNumber(customerOrder.getOrderNumber());

        return cartSelectionRepository.save(cartSelection);
    }

    private CustomerOrder findOrCreateNewCustomerOrder(UUID customerId) {
        CustomerOrder customerOrder;

        if (!doesCustomerOrderAlreadyExist(customerId)) {
            customerOrder = new CustomerOrder();
            customerOrder.setCustomerId(customerId);
        } else {
            customerOrder = customerOrderRepository.findNotCompletedCustomerOrderByCustomerId(customerId);
        }

        return customerOrder;
    }

    private boolean doesCustomerOrderAlreadyExist(UUID customerId) {
        return cartSelectionRepository.findCustomerOrderCountByCustomerId(customerId) != 0;
    }

    private List<CartSelection> findAllCartSelectionsForCustomerForCustomerOrderTotal(CartSelection cartSelection) {
        List<CartSelection> cartSelections = cartSelectionRepository.findAllCartSelectionsByCustomerId(cartSelection.getCustomerId());
        cartSelections.add(cartSelection);

        return cartSelections;
    }

    private void handleCustomerOrder(CustomerOrder customerOrder, List<CartSelection> cartSelections) {
        customerOrder.setOrderTotal(getCurrentOrderTotal(cartSelections));
        customerOrderRepository.save(customerOrder);
    }

    private BigDecimal getCurrentOrderTotal(List<CartSelection> cartSelections) {
        List<BigDecimal> itemPrices = new ArrayList<>();

        for (CartSelection cartSelection : cartSelections) {
            BigDecimal itemPrice = itemRepository.findItemByItemId(cartSelection.getItemId()).getPrice();
            itemPrices.add(itemPrice);
        }

        return itemPrices.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
