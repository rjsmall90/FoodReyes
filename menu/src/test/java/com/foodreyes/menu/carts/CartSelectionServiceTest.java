package com.foodreyes.menu.carts;

import com.foodreyes.menu.items.Item;
import com.foodreyes.menu.items.ItemRepository;
import com.foodreyes.menu.orders.CustomerOrder;
import com.foodreyes.menu.orders.CustomerOrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CartSelectionServiceTest {

    private List<CartSelectionDTO> cartSelectionDTOS;
    private CartSelectionDTO cartSelectionDTO;
    private CustomerOrder customerOrder;
    private List<CartSelection> cartSelections;
    private CartSelection cartSelection;
    private Item item;

    private final static UUID TEST_CUSTOMER_ID = UUID.fromString("5352522f-48a2-4bb9-8108-3b432a99bd6b");
    private static final Long TEST_ITEM_NUMBER = 1L;

    @Mock
    private CartSelectionRepository cartSelectionRepository;

    @Mock
    private CustomerOrderRepository customerOrderRepository;

    @Mock
    private ItemRepository itemRepository;

    private CartSelectionService cartSelectionService;

    @BeforeEach
    public void setUp() {
        customerOrder = new CustomerOrder();

        cartSelection = new CartSelection();
        cartSelection.setCustomerId(TEST_CUSTOMER_ID);
        cartSelection.setItemId(TEST_ITEM_NUMBER);

        cartSelections = new ArrayList<>();
        cartSelections.add(cartSelection);

        item = new Item();
        item.setPrice(BigDecimal.TEN);

        cartSelectionDTO = new CartSelectionDTO();

        cartSelectionDTOS = new ArrayList<>();
        cartSelectionDTOS.add(cartSelectionDTO);

        cartSelectionService = new CartSelectionService(
                cartSelectionRepository,
                customerOrderRepository,
                itemRepository
        );
    }

    @Test
    public void findAllCartSelectionsForCustomer() {
        when(cartSelectionRepository.findCartSelectionDTOsByCustomerId(TEST_CUSTOMER_ID)).thenReturn(cartSelectionDTOS);

        List<CartSelectionDTO> dtos = cartSelectionService.findAllCartSelectionsForCustomer(TEST_CUSTOMER_ID);

        Assertions.assertEquals(cartSelectionDTOS, dtos, "DTOs do not match");
    }

    @Test
    public void addItemToCart() {
        when(cartSelectionRepository.findCustomerOrderCountByCustomerId(TEST_CUSTOMER_ID)).thenReturn(1);
        when(customerOrderRepository.findNotCompletedCustomerOrderByCustomerId(TEST_CUSTOMER_ID)).thenReturn(customerOrder);
        when(cartSelectionRepository.findAllCartSelectionsByCustomerId(TEST_CUSTOMER_ID)).thenReturn(cartSelections);
        when(itemRepository.findItemByItemId(TEST_ITEM_NUMBER)).thenReturn(item);
        when(customerOrderRepository.save(any(CustomerOrder.class))).thenReturn(customerOrder);
        when(cartSelectionRepository.save(any(CartSelection.class))).thenReturn(cartSelection);

        CartSelection selection = cartSelectionService.addItemToCart(cartSelection);

        Assertions.assertEquals(cartSelection, selection, "Selections do not match");
    }
}