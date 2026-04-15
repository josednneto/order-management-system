package com.ordersystem.model.service;

import com.ordersystem.model.entities.ItemOrder;
import com.ordersystem.model.entities.Order;
import com.ordersystem.model.entities.Product;
import com.ordersystem.model.exceptions.*;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private List<Order> orders = new ArrayList<>();
    private List<Product> products = new ArrayList<>();


    public OrderService(){
    }

    public OrderService(List<Order> orders, List<Product> products) {
        this.orders = orders;
        this.products = products;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<Product> getProducts() {
        return products;
    }


    public void productRegister(Product product) {
        if (product == null) {
            throw new InvalidProductException();
        }

        for (Product p : products) {
            if (p.getId().equals(product.getId())) {
                throw new ProductAlreadyExistsException();
            }
        }

        products.add(product);
    }

    public void createOrder(int orderId){
        for(Order order : orders){
            if (order.getId().equals(orderId)){
                throw new OrderAlreadyExistsException();
            }
        }
        orders.add(new Order(orderId));
    }

    private Order searchOrder(int orderId){
       for(Order order : orders){
           if(order.getId().equals(orderId)){
               return order;
           }
       }
       throw new OrderNotFoundException();
    }

    private Product searchProduct(int productId){
        for(Product product : products){
            if(product.getId().equals(productId)){
                return product;
            }
        }
        throw new ProductNotFoundException();
    }

    public void addItem(int orderId, int productId, int unit){
        Order order = searchOrder(orderId);
        Product product = searchProduct(productId);

        if(order.isFinished()){
            throw new OrderCompletedException();
        }

        product.drawStock(unit);
        order.addItem(product, unit);
    }

    public void removeItem(int orderId, int productId){
        Order order = searchOrder(orderId);
        if(order.isFinished()){
            throw new OrderCompletedException();
        }

        Product product = searchProduct(productId);

        ItemOrder itemOrder = order.searchItem(productId);

        product.addStock(itemOrder.getQuantity());
        order.removeItem(productId);
    }

    public void orderFinish(int orderId){
        Order order = searchOrder(orderId);
        if(order.isFinished()){
            throw new OrderCompletedException();
        }

        order.finishedOrder();
    }

    public void listProducts(){
        System.out.println("-----------------------------");
        for(Product product: products){
            System.out.println("[ID: " + product.getId() + "] " + product.getName() + ", unit: " + product.getInventory());
        }
    }
    public void listOrders(){
        for(Order order: orders){
            System.out.println("-----------------------------");
            System.out.println("Order id: " + order.getId());

            System.out.println("Order items: ");
            for(ItemOrder item : order.getItems()){
                System.out.println("[ID: " + item.getProduct().getId() +
                        "] " + item.getProduct().getName() +
                        ", Quantity: " + item.getQuantity());
            }

            System.out.println("Total order: $" + String.format("%.2f", order.calculateTotal()));
            System.out.println("Order status: " + order.getStatus());
        }
    }
}
