package com.foodreyes.menu.orders;

import com.foodreyes.menu.notifications.CustomerOrderNotifier;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class CustomerOrderService {

    private final CustomerOrderRepository customerOrderRepository;
    private final CustomerOrderMapper customerOrderMapper;
    private final CustomerOrderNotifier customerOrderNotifier;

    CustomerOrder submitPaidOrder(Long orderNumber) {
        CustomerOrder customerOrder = customerOrderRepository.findByOrderNumber(orderNumber);

        customerOrder.setPaid(true);

        customerOrderRepository.save(customerOrder);

        customerOrderNotifier.sendCustomerOrderNotification(customerOrderMapper.buildCustomerOrderDTO(customerOrder));

        return customerOrder;
    }
}
