package com.demo.orderservice.models;



import javax.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


public class Order {


   // Integer id;
    String orderNumber;
    String username;
    String email;
    List<Product> items;
    double total;
    String address;
    LocalDate date;

    Order(){

    }

    public Order( String username, String email, List<Product> items, double total, String address) {
        this.username = username;
        this.email = email;
        this.items = items;
        this.total = total;
        this.address = address;
    }

   /* public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }*/

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Product> getItems() {
        return items;
    }

    public void setItems(List<Product> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        String itemDetailsHeader = "Item\tPrice\tSize\n";
        String itemDetails = "";
        for(Product item: items){
            itemDetails += item.toString() + "\n";
        }

        return "Thank you "+username+" for shopping with VAPH"+'\n'+
                "Order Details:"+'\n'+
                "orderNumber: " + orderNumber +'\n'+
                "Placed on:" + date +'\n'+
                "Email: " + email + "\n\n" +
                itemDetailsHeader +
                itemDetails + "\n" +
                "Total: $" + total +'\n'+
                "Address: " + address +'\n';
    }




}
