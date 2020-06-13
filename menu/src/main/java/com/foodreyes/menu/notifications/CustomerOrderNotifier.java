package com.foodreyes.menu.notifications;

import com.foodreyes.menu.orders.CustomerOrderDTO;

public interface CustomerOrderNotifier {

    void sendCustomerOrderNotification(CustomerOrderDTO dto);
}
