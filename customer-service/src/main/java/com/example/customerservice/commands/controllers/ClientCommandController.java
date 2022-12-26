package com.example.customerservice.commands.controllers;

import com.example.commonapi.commands.CreateClientCommand;
import com.example.commonapi.dtos.CreateClientRequestDTO;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/commands/customers")
@AllArgsConstructor
public class ClientCommandController {
    private CommandGateway commandGateway;

    @PostMapping(path = "/create")
    public CompletableFuture<String> createClient(@RequestBody CreateClientRequestDTO clientRequestDTO) {
        CompletableFuture<String> response = commandGateway.send(new CreateClientCommand(
                UUID.randomUUID().toString(),
                clientRequestDTO.getNom(),
                clientRequestDTO.getAdresse(),
                clientRequestDTO.getEmail(),
                clientRequestDTO.getTel()
        ));
        return response;
    }

}