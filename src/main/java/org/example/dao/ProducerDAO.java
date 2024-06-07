package org.example.dao;

import org.example.HibernateUtil;
import org.example.model.Consumer;
import org.example.model.Producer;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;

public class ProducerDAO {

    private static Scanner scanner = new Scanner(System.in);

    public static Producer getProducer(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (session.get(Producer.class,id));
    }

    public void addConsumer () {
        Consumer consumer = new Consumer();
        Producer producer = new Producer();
        System.out.print("Name : ");
        consumer.setName(scanner.next());
        System.out.print("Email : ");
        consumer.setEmail(scanner.next());
        System.out.print("Password : "); // Ne pas oublier de le HASH
        consumer.setPassword(scanner.next());
        System.out.print("Address : ");
        consumer.setAddress(scanner.next());
        System.out.print("Phone : ");
        consumer.setPhone(scanner.next());
        System.out.print("Are you Producer : Yes / No = y / n");//Condition pour ajouter n°siret
        char pro = scanner.next().charAt(0);
        switch (pro){
            case 'y':
            case 'Y': {
                consumer.setProducer(true);
                System.out.print("Siret Number : ");
                producer.setId_consumer(consumer.getId());
                producer.setSiretNumber(scanner.next());
                break;
            }
            case 'n':
            case 'N': {
                consumer.setProducer(false);
                break;
            }
            default: {
                System.out.println ("'y' / 'Y' or 'n' / 'N'");
            }
        }
        Session session = null;
        Transaction tr = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();
            session.persist(consumer);
            if (pro == 'y' || pro == 'Y'){
                session.persist(producer);
            }
            tr.commit();
            System.out.println("Account created successfully");
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
