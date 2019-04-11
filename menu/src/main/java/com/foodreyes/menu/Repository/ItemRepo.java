package com.foodreyes.menu.Repository;

import com.foodreyes.menu.Model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends CrudRepository<Item, Long> {
}
