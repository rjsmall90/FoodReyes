package com.foodreyes.menu.customers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    @Query("Select c " +
            "From Customer c " +
            "Where c.customerId = :customerId")
    Customer findCustomerByCustomerId(UUID customerId);
}
