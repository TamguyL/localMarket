package org.example.controller;

import org.example.dao.ProducerDAO;
import org.example.dao.ProductDAO;
import org.example.model.Consumer;
import org.example.model.Producer;
import org.example.model.Product;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class MarketController {

    private List<Product> Products;
    private ProductDAO daoProduct = new ProductDAO();
    private ProducerDAO daoProducer = new ProducerDAO();


    public MarketController() {
        this.Products = new ArrayList();
    }

    public void addConsumer () {
        daoProducer.addConsumer();
    }

    // Product
    public void displayProducts(){
        List<Product> products = ProductDAO.getProducts();
        System.out.println("Liste");
        for(Product product : products){
            System.out.println(product.getId() + " Name :" + product.getName() + " Quantity :" + product.getQuantity() + " Price :"+ product.getPrice());
        }
    }
    public void displayProduct(int id){
        Product product = ProductDAO.getProduct(id);
        if (product != null) {
            System.out.println("ID: " + product.getId() + " Name :" + product.getName() + " Quantity :" + product.getQuantity() + " Price :"+ product.getPrice() + "\r\n");
        } else {
            System.out.println("Product not found with ID: " + id);
        }
    }
    public void newProduct(int idProducer, String name, int quantity, double price){
        Product product = new Product(idProducer, name, quantity, price);
        daoProduct.newProduct(product);
    }
    public void updateProduct(int id, int idProducer, String name, int quantity, double price) {
        Product product = new Product(id, idProducer, name, quantity, price);
        daoProduct.updateProduct(product);
    }
    public void deleteProduct(int id) {
        daoProduct.deleteProduct(id);
    }


}
