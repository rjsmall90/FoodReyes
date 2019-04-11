package com.foodreyes.menu.Repository;

import com.foodreyes.menu.Model.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends CrudRepository<Cart, Long> {
}
