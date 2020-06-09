package com.foodreyes.menu.Repository;

import com.foodreyes.menu.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<Item, Long> {

    Item findByName(String name);
}
