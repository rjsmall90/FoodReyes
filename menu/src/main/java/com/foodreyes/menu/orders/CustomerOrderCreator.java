package com.foodreyes.menu.orders;

import java.util.UUID;

public interface CustomerOrderCreator {

    CustomerOrder createInitialOrder(UUID customerId);
}
