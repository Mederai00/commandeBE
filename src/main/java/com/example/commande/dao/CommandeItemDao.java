package com.example.commande.dao;

import com.example.commande.bean.Commande;
import com.example.commande.bean.CommandeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeItemDao extends JpaRepository<CommandeItem,Long> {

    public int deleteByCommandeReference(String ref);
    public List<CommandeItem> findByCommandeReference(String ref);
}
