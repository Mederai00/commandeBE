package com.example.commande.ws.provided;

import com.example.commande.bean.Commande;
import com.example.commande.service.facade.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Access;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("v1/stock-api/commande")
public class CommandeRes {

    @GetMapping("/ref/{ref}")
    public Commande findByRef(@PathVariable String ref) {
        return commandeService.findByReference(ref);
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return commandeService.deleteByReference(ref);
    }

    @PostMapping("/")
    public int save(@RequestBody Commande commande) {
        return commandeService.save(commande);
    }

    @GetMapping("/")
    public List<Commande> findAll() {
        return commandeService.findAll();
    }

    @Autowired
    private CommandeService commandeService;
}
