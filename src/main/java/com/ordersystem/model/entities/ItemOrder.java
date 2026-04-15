package com.ordersystem.model.entities;

public class ItemOrder {
    private Product product;
    private Integer quantity;

    public ItemOrder(){
    }

    public ItemOrder(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
