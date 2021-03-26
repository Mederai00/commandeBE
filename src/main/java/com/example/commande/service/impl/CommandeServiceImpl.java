package com.example.commande.service.impl;

import com.example.commande.bean.Commande;
import com.example.commande.bean.CommandeItem;
import com.example.commande.dao.CommandeDao;
import com.example.commande.service.facade.CommandeItemService;
import com.example.commande.service.facade.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CommandeServiceImpl implements CommandeService {
    @Autowired
    private CommandeDao commandeDao;

    @Autowired
    private CommandeItemService commandeItemService;

    @Override
    public Commande findByReference(String ref) {
        return commandeDao.findByReference(ref);
    }

    @Override
    @Transactional
    public int deleteByReference(String ref) {
        int res1 = commandeItemService.deleteByCommandeReference(ref);
        int res2 = commandeDao.deleteByReference(ref);
        return res1+res2;
    }

    @Override
    public int save(Commande commande) {
        if(findByReference(commande.getReference()) != null)
            return -1;
        else {
            calculerTotal(commande,commande.getCommandeItems());
            commandeDao.save(commande);
            commandeItemService.save(commande,commande.getCommandeItems());
            return 1;
        }
    }

    @Override
    public List<Commande> findAll() {
        return commandeDao.findAll();
    }

    private void calculerTotal(Commande commande, List<CommandeItem> commandeItems) {
        double total = 0;
        for (CommandeItem commandeItem : commandeItems) {
            total+= commandeItem.getPrix() * commandeItem.getQte();
        }
        commande.setTotal(total);
    }
}
