package com.example.inventoryservice.query.service;

import com.example.commonapi.events.ProduitCreatedEvent;
import com.example.commonapi.queries.GetAllProduits;
import com.example.inventoryservice.query.entities.Produit;
import com.example.inventoryservice.query.repositories.ProduitRepository;
import lombok.AllArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class ProduitServiceHandler {
    private ProduitRepository produitRepository;

    @EventHandler
    public void on(ProduitCreatedEvent event){
        Produit produit = new Produit();
        produit.setId(event.getId());
        produit.setNom(event.getNom());
        produit.setPrix(event.getPrix());
        produit.setQte(event.getQte());
        produit.setEtat(event.getEtat());
        produitRepository.save(produit);
    }

    @QueryHandler
    public List<Produit> on(GetAllProduits query){
        return produitRepository.findAll();
    }

}
