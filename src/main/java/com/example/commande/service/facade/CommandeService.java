package com.example.commande.service.facade;

import com.example.commande.bean.Commande;

import java.util.List;

public interface CommandeService {

    public Commande findByReference(String ref);
    public int deleteByReference(String ref);

    public int save(Commande commande);
    public List<Commande> findAll();

}
