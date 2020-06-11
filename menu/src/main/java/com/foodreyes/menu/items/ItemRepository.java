package com.foodreyes.menu.items;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("Select i " +
            "From Item i " +
            "Where i.itemId = :itemId")
    Item findItemByItemId(@Param("itemId") Long itemId);
}
