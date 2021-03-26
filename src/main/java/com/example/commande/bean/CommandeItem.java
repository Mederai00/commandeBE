package com.example.commande.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class CommandeItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Produit;
    private double prix;
    private double qte;
    @ManyToOne
    private Commande commande;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduit() {
        return Produit;
    }

    public void setProduit(String ref) {
        this.Produit = ref;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double total) {
        this.prix = total;
    }

    public double getQte() {
        return qte;
    }

    public void setQte(double totalPaye) {
        this.qte = totalPaye;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }
}
