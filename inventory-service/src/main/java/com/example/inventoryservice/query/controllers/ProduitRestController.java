package com.example.inventoryservice.query.controllers;

import com.example.commonapi.queries.GetAllClients;
import com.example.commonapi.queries.GetAllProduits;
import com.example.inventoryservice.query.entities.Produit;
import lombok.AllArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/query/products")
@AllArgsConstructor
public class ProduitRestController {
    private QueryGateway queryGateway;

    @GetMapping("/allProducts")
    public List<Produit> getAllProduits(){
        return queryGateway.query(new GetAllProduits(), ResponseTypes.multipleInstancesOf(Produit.class)).join();
    }/**/
}
