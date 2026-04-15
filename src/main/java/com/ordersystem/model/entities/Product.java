package com.ordersystem.model.entities;

import com.ordersystem.model.exceptions.InsufficientStockException;
import com.ordersystem.model.exceptions.InvalidQuantityException;
import com.ordersystem.model.exceptions.ProductNullValueException;

public class Product {
    private Integer id;
    private String name;
    private Double price;
    private Integer inventory;

    public Product(){
    }

    public Product(Integer id, String name, Double price, Integer inventory) {
        if (id == null) {
            throw new ProductNullValueException();
        }

        if(inventory == null || inventory < 0){
            throw new InvalidQuantityException();
        }
        this.id = id;
        this.name = name;
        this.price = price;
        this.inventory = inventory;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void addStock(int unit){
        if(unit <= 0){
            throw new InvalidQuantityException();
        }
        this.inventory += unit;
    }

    public void drawStock(int unit){
        if(unit <= 0 ){
            throw new InvalidQuantityException();
        }
        if(unit > inventory){
            throw new InsufficientStockException();
        }
        this.inventory -= unit;
    }
}
