package com.example.commande.ws.provided;

import com.example.commande.bean.Commande;
import com.example.commande.bean.CommandeItem;
import com.example.commande.service.facade.CommandeItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/v1/stock-api/commande-item")
public class CommandeItemRes {
    @Autowired
    CommandeItemService commandeItemService;

    @GetMapping("/commande/ref/{ref}")
    public List<CommandeItem> findByCommandeRef(@PathVariable String ref) {
        return commandeItemService.findByCommandeReference(ref);
    }


    @DeleteMapping("/commande/ref/{ref}")
    public int deleteByCommandeRef(@PathVariable String ref) {
        return commandeItemService.deleteByCommandeReference(ref);
    }

}