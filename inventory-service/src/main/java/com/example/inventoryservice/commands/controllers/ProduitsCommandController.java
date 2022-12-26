package com.example.inventoryservice.commands.controllers;

import com.example.commonapi.commands.CreateClientCommand;
import com.example.commonapi.commands.CreateProduitCommand;
import com.example.commonapi.dtos.CreateClientRequestDTO;
import com.example.commonapi.dtos.CreateProduitRequestDTO;
import com.example.commonapi.enums.EtatPdt;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/commands/products")
@AllArgsConstructor
public class ProduitsCommandController {
    private CommandGateway commandGateway;

    @PostMapping(path = "/create")
    public CompletableFuture<String> createProduit(@RequestBody CreateProduitRequestDTO produitRequestDTO) {
        CompletableFuture<String> response = commandGateway.send(new CreateProduitCommand(
                UUID.randomUUID().toString(),
                produitRequestDTO.getNom(),
                produitRequestDTO.getPrix(),
                produitRequestDTO.getQte(),
                EtatPdt.Disponible
        ));
        return response;
    }

}