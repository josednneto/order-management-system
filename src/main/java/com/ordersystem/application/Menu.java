package com.ordersystem.application;

import com.ordersystem.model.entities.Product;
import com.ordersystem.model.exceptions.OrderException;
import com.ordersystem.model.exceptions.ProductAlreadyExistsException;
import com.ordersystem.model.service.OrderService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private final OrderService orderService = new OrderService();
    private final Scanner sc = new Scanner(System.in);

    public void run(){
        int op = 0;

        do{
            System.out.println();
            menu();
            op = readInt();
            System.out.println();
            try {
                switch (op){
                    case 1:
                        productRegister(sc, orderService);
                        break;
                    case 2:
                        createOrder(orderService);
                        break;
                    case 3:
                        addItem(orderService);
                        break;
                    case 4:
                        removeItem(orderService);
                        break;
                    case 5:
                        orderFinish(orderService);
                        break;
                    case 6:
                        listOrders(orderService);
                        break;
                    case 7:
                        listProducts(orderService);
                        break;
                }
            }catch (OrderException e){
                System.out.println("Error: " + e.getMessage());
            }
        }while(op != 0);
    }

    private void menu(){
        System.out.println("=== MENU ===");
        System.out.println("1 - Register product");
        System.out.println("2 - New order");
        System.out.println("3 - Add item to order");
        System.out.println("4 - Remove item from order");
        System.out.println("5 - Order finish");
        System.out.println("6 - List orders");
        System.out.println("7 - List products");
        System.out.println("0 - Exit.");
        System.out.print(": ");
    }

    private int readInt(){
        int value = 0;
        boolean valid;

        do{
            valid = true;
            try {
                value = sc.nextInt();
                sc.nextLine();
            }
            catch (InputMismatchException e){
                System.out.print("Invalid number. Try again: ");
                sc.nextLine();
                valid = false;
            }
        }while (!valid);

        return value;
    }

    private double readDouble(){
        double value = 0;
        boolean valid;

        do{
            valid = true;
            try {
                value = sc.nextDouble();
                sc.nextLine();
            }
            catch (InputMismatchException e){
                System.out.print("Invalid number. Try again: ");
                sc.nextLine();
                valid = false;
            }
        }while (!valid);

        return value;
    }

    private void productRegister(Scanner sc, OrderService orderService){
        try {
            System.out.print("Id: ");
            int id = readInt();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Price $: ");
            double price = readDouble();

            System.out.print("Inventory (unit): ");
            int inventory = readInt();

            Product product = new Product(id, name, price, inventory);
            orderService.productRegister(product);

            System.out.println("Product successfully registered!");
        }
        catch (ProductAlreadyExistsException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void createOrder(OrderService orderService){
        try {
            System.out.print("Enter a order id: ");
            int orderId = readInt();

            orderService.createOrder(orderId);
            System.out.println("New order created.");
        }
        catch (OrderException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void addItem(OrderService orderService){
        try {
            System.out.print("Enter a order id: ");
            int orderId = readInt();

            System.out.print("Enter a product id: ");
            int productId = readInt();

            System.out.print("Enter the quantity of the product (unit): ");
            int unit = readInt();

            orderService.addItem(orderId, productId, unit);
            System.out.println("Item added to order!");
        }
        catch (OrderException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void removeItem(OrderService orderService){
        try {
            System.out.print("Enter a order id: ");
            int orderId = readInt();

            System.out.print("Enter a product id: ");
            int productId = readInt();

            orderService.removeItem(orderId, productId);
            System.out.println("Item successfully removed from the order!");
        }
        catch (OrderException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void orderFinish(OrderService orderService){
        try {
            System.out.print("Enter a order id: ");
            int orderId = readInt();

            orderService.orderFinish(orderId);
            System.out.println("Order finished successfully!");
        }
        catch (OrderException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void listOrders(OrderService orderService){
        orderService.listOrders();
    }

    private void listProducts(OrderService orderService){
        orderService.listProducts();
    }
}
