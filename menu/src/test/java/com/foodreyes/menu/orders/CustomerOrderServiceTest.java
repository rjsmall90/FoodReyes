package com.foodreyes.menu.orders;

import com.foodreyes.menu.notifications.CustomerOrderNotifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerOrderServiceTest {

    private CustomerOrder customerOrder;
    private CustomerOrderDTO customerOrderDTO;

    private static final Long ORDER_NUMBER = 1L;

    @Mock
    private CustomerOrderRepository customerOrderRepository;

    @Mock
    private CustomerOrderMapper customerOrderMapper;

    @Mock
    private CustomerOrderNotifier customerOrderNotifier;

    private CustomerOrderService customerOrderService;

    @BeforeEach
    void setUp() {
        customerOrder = new CustomerOrder();
        customerOrder.setPaid(false);

        customerOrderDTO = new CustomerOrderDTO();

        customerOrderService = new CustomerOrderService(
                customerOrderRepository,
                customerOrderMapper,
                customerOrderNotifier
        );
    }

    @Test
    void submitPaidOrder() {
        when(customerOrderRepository.findByOrderNumber(ORDER_NUMBER)).thenReturn(customerOrder);
        when(customerOrderRepository.save(customerOrder)).thenReturn(customerOrder);
        when(customerOrderMapper.buildCustomerOrderDTO(customerOrder)).thenReturn(customerOrderDTO);

        CustomerOrder order = customerOrderService.submitPaidOrder(ORDER_NUMBER);

        Assertions.assertTrue(customerOrder.isPaid());
        Assertions.assertEquals(customerOrder, order, "Customer orders do not match");
        verify(customerOrderNotifier, times(1)).sendCustomerOrderNotification(customerOrderDTO);
    }
}