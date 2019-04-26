package com.demo.productservice.TestUtils;


import java.util.ArrayList;
import java.util.List;

public class TestProducts {
    public static List<Product> getProducts(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("blue men cotton shirt","Men", "Shirts", 10.00, "M", 10));
        products.add(new Product("black men jeans pant","Men", "Pants", 11.00, "L", 15));
        products.add(new Product("blue men cotton shirt","Men", "Shirts", 10.00, "S", 17));
        products.add(new Product("Red women chiffon top","Women", "Tops", 15.99, "S", 6));
        products.add(new Product("blue women freels dress","Women", "Dresses", 30.00, "M", 4));
        products.add(new Product("pink barbie doll dress","Girls", "Dresses", 25.00, "S", 3));
        products.add(new Product("red jeans pant for girls","Girls", "Pants", 17.00, "XL", 12));
        products.add(new Product("spiderman blue shirt","Boys", "Shirts", 19.00, "S", 16));
        products.add(new Product("torn black jeans for boys","Boys", "Pants", 4.50, "M", 10));
        return products;
    }
}

