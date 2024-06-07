package org.example.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private int idProducer;
    private String name;
    private int quantity;
    private double price;

    public int getId() {
        return id;
    }
    public int getIdProducer() {
        return idProducer;
    }
    public String getName() {
        return name;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setIdProducer(int idProducer) {
        this.idProducer = idProducer;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public Product() {}
    public Product(int id, int idProducer, String name, int quantity, double price) {
        this.id = id;
        this.idProducer = idProducer;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    public Product(int idProducer, String name, int quantity, double price) {
        this.idProducer = idProducer;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }


}
