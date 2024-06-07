package org.example.model;

import javax.persistence.*;

@Entity
@Table(name = "producer")
public class Producer extends Consumer{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String siretNumber;
    private int id_consumer;

    public String getSiretNumber() {
        return siretNumber;
    }
    public void setSiretNumber(String siretNumber) {
        this.siretNumber = siretNumber;
    }
    public int getId_consumer() {
        return id_consumer;
    }
    public void setId_consumer(int id_consumer) {
        this.id_consumer = id_consumer;
    }

    public Producer() {}
    public Producer(int id, String name, String email, String password, String address, String phone, Boolean producer, String siretNumber) {
        super(id, name, email, password, address, phone, producer);
        this.siretNumber = siretNumber;
    }
    public Producer(int id_consumer, String siretNumber) {
        this.id_consumer = id_consumer;
        this.siretNumber = siretNumber;
    }
}
