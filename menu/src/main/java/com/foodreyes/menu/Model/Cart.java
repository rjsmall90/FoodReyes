package com.foodreyes.menu.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Shopping_Cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long orderNumber;

    @OneToOne(targetEntity = Item.class)
    List<Item> item;

    String total;

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long id) {
        this.orderNumber = id;
    }

    public List<Item> getItems() {
        return this.item;
    }

    public void setItems(List<Item> items) {
        this.item = items;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
