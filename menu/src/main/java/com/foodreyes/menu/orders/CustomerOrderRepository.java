package com.foodreyes.menu.orders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {

    @Query("Select co " +
            "From CustomerOrder co " +
            "Where co.customerId = :customerId " +
            "And co.paid = false")
    CustomerOrder findNotCompletedCustomerOrderByCustomerId(@Param("customerId") UUID customerId);
}
