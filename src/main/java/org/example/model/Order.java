package org.example.model;

import java.util.List;

public class Order {
    public int idConsumer;
    public List<Product> products;

    public int getIdConsumer() {
        return idConsumer;
    }
    public List<Product> getProducts() {
        return products;
    }

    public void setIdConsumer(int idConsumer) {
        this.idConsumer = idConsumer;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Order(int idConsumer, List<Product> products) {
        this.idConsumer = idConsumer;
        this.products = products;
    }

}
