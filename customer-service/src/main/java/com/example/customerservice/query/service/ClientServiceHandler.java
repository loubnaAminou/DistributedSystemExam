package com.example.customerservice.query.service;

import com.example.commonapi.events.ClientCreatedEvent;
import com.example.commonapi.queries.GetAllClients;
import com.example.customerservice.query.entities.Client;
import com.example.customerservice.query.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class ClientServiceHandler {
    private ClientRepository clientRepository;

    @EventHandler
    public void on(ClientCreatedEvent event){
        Client client = new Client();
        client.setId(event.getId());
        client.setNom(event.getNom());
        client.setAdresse(event.getAdresse());
        client.setEmail(event.getEmail());
        client.setTel(event.getTel());
        clientRepository.save(client);
    }

    @QueryHandler
    public List<Client> on(GetAllClients query){
        return clientRepository.findAll();
    }

}
