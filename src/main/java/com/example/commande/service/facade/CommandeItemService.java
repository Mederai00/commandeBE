package com.example.commande.service.facade;

import com.example.commande.bean.Commande;
import com.example.commande.bean.CommandeItem;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CommandeItemService {
    public List<CommandeItem> findByCommandeReference(String ref);
    public int deleteByCommandeReference(String ref);
    public int save(Commande commande, List<CommandeItem> commandeItems);
}
