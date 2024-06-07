package org.example.dao;

import org.example.HibernateUtil;
import org.example.model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProductDAO {

    // Crud Product
    // Il faut un modifier pour ajouter automatiquement idProducer
    public static Product getProduct(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (session.get(Product.class,id));
    }
    public static List<Product> getProducts() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (session.createQuery("FROM Product", Product.class).getResultList());
    }
    public void newProduct(Product prod) {
        Session session = null;
        Transaction tr = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();
            session.persist(prod);
            tr.commit();
            System.out.println("Product added with id: " + prod.getId());
        } catch (Exception ex) {
            if (tr != null) {
                tr.rollback();
            }
            ex.getMessage();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    public void updateProduct(Product prod) {
        Session session = null;
        Transaction tr = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();
            session.update(prod);
            tr.commit();
            System.out.println("Product update with id: " + prod.getId());
        } catch (Exception ex) {
            if (tr != null) {
                tr.rollback();
            }
            ex.getMessage();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    public void deleteProduct(int id) {
        Session session = null;
        Transaction tr = null;
        Product prod = new Product();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();
            prod.setId(id);
            session.delete(prod);
            tr.commit();
            System.out.println("Product delete with id: " + prod.getId());
        } catch (Exception ex) {
            if (tr != null) {
                tr.rollback();
            }
            ex.getMessage();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


}
