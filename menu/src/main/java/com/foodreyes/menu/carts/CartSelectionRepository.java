package com.foodreyes.menu.carts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CartSelectionRepository extends JpaRepository<CartSelection, Long> {

    @Query("Select Count(co) " +
            "From CustomerOrder co " +
            "Where co.customerId = :customerId")
    Integer findCustomerOrderCountByCustomerId(@Param("customerId") UUID customerId);

    @Query("Select cs " +
            "From CartSelection cs " +
            "Where cs.customerId = :customerId")
    List<CartSelection> findAllCartSelectionsByCustomerId(@Param("customerId") UUID customerId);
}
