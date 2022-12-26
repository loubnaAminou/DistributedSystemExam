package com.example.customerservice.query.controllers;

import com.example.commonapi.queries.GetAllClients;
import com.example.customerservice.query.entities.Client;
import lombok.AllArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/query/customers")
@AllArgsConstructor
public class ClientRestController {
    private QueryGateway queryGateway;

    @GetMapping("/allCustomers")
    public List<Client> getAllClients(){
        return queryGateway.query(new GetAllClients(), ResponseTypes.multipleInstancesOf(Client.class)).join();
    }
}
