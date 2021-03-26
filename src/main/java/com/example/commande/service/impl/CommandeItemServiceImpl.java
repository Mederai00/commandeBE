package com.example.commande.service.impl;

import com.example.commande.bean.Commande;
import com.example.commande.bean.CommandeItem;
import com.example.commande.dao.CommandeItemDao;
import com.example.commande.service.facade.CommandeItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class CommandeItemServiceImpl implements CommandeItemService {
    @Override
    public List<CommandeItem> findByCommandeReference(String ref) {
        return commandeItemDao.findByCommandeReference(ref);
    }

    @Override
    @Transactional
    public int deleteByCommandeReference(String ref) {
        return commandeItemDao.deleteByCommandeReference(ref);
    }

    @Override
    public int save(Commande commande, List<CommandeItem> commandeItems) {
        for (CommandeItem commandeItem : commandeItems) {
            commandeItem.setCommande(commande);
            commandeItemDao.save(commandeItem);
        }
        return 1;
    }

    @Autowired
    private CommandeItemDao commandeItemDao;
}
