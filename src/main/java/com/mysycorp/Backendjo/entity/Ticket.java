package com.mysycorp.Backendjo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Ticket {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seat;
    private boolean used;  // Utilisez uniquement 'used'

    @ManyToOne
    @JoinColumn(name = "achat_id")
    private Achat achat;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public boolean isUsed() {
        return used;  // Retournez la variable 'used'
    }

    public void setUsed(boolean used) {
        this.used = used;  // Mettez à jour la variable 'used'
    }

    public Achat getAchat() {
        return achat;
    }

    public void setAchat(Achat achat) {
        this.achat = achat;
    }

    public Object getPrice() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPrice'");
    }

    public void setPrice(Object price) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPrice'");
    }
}
