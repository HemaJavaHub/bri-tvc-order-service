package com.demo.orderservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Product {

    Integer id;
    String name;
    String category;
    String sub_category;
    double price;
    String size;
    int count;

    public Product(String name, String category, String sub_category, double price, String size, int count) {
        this.name=name;
        this.category = category;
        this.sub_category = sub_category;
        this.price = price;
        this.size = size;
        this.count = count;
    }


    Product(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSub_category() {
        return sub_category;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setSub_category(String sub_category) {
        this.sub_category = sub_category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return  name + "\t$" + price + "\t" +  size;
    }
}
