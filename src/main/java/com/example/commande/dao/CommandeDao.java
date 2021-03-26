package com.example.commande.dao;

import com.example.commande.bean.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeDao extends JpaRepository<Commande,Long> {
    public Commande findByReference(String ref);
    public int deleteByReference(String ref);
}
