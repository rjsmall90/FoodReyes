package com.foodreyes.menu.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Shopping_Cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long orderNumber;

    @ManyToOne(targetEntity = Item.class)
    List<Item> itemId;

    Double total;

    public Cart(Long id, List<Item> items, Double total) {
        this.orderNumber = id;
        this.itemId = items;
        this.total = total;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long id) {
        this.orderNumber = id;
    }

    public List<Item> getItems() {
        return itemId;
    }

    public void setItems(List<Item> items) {
        this.itemId = items;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
