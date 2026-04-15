package com.systemdelivery.model.entities;

import com.systemdelivery.model.exceptions.OrderCompletedException;
import com.systemdelivery.model.exceptions.ProductNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Integer id;
    private List<ItemOrder> items;
    private Double total;
    private boolean finished;

    public Order(){
        items = new ArrayList<>();
        this.total = 0.0;
        this.finished = false;
    }

    public Order(Integer id) {
        this.id = id;
        this.items = new ArrayList<>();
        this.total = 0.0;
        this.finished = false;
    }

    public Integer getId() {
        return id;
    }

    public List<ItemOrder> getItems() {
        return items;
    }

    public Double getTotal() {
        return total;
    }

    public String getStatus(){
        if(isFinished()){
            return "Finished";
        }
        return "Unfinished";
    }

    public boolean isFinished() {
        return finished;
    }
    public void finishedOrder(){
        this.finished = true;
    }

    public double calculateTotal(){
        double sum = 0.0;
        for(ItemOrder item : items){
            sum += item.getProduct().getPrice() * item.getQuantity();
        }
        return sum;
    }

    public  ItemOrder searchItem(int productId){
        for(ItemOrder item : items){
            if(item.getProduct().getId().equals(productId)){
                return item;
            }
        }
        throw new ProductNotFoundException();
    }

    public void addItem(Product product, int unit){
        if(finished){
            throw new OrderCompletedException();
        }
        items.add(new ItemOrder(product, unit));
        total = calculateTotal();
    }

    public void removeItem(int productId){
        if(finished){
            throw new OrderCompletedException();
        }
        items.remove(searchItem(productId));
        total = calculateTotal();
    }
}
