package com.example.customerservice.commands.aggregates;

import com.example.commonapi.commands.CreateClientCommand;
import com.example.commonapi.events.ClientCreatedEvent;
import lombok.Getter;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class ClientAggregate {
    @AggregateIdentifier
    private String clientId;
    private String nom;
    private String adresse;
    private String email;
    private String tel;

    public ClientAggregate() {
        //Obligatoire par Axon
    }

    @CommandHandler
    public ClientAggregate(CreateClientCommand command){
        AggregateLifecycle.apply(new ClientCreatedEvent(
                command.getId(),
                command.getNom(),
                command.getAdresse(),
                command.getEmail(),
                command.getTel()
                ));
    }

    @EventSourcingHandler //émutter l'état de l'aggregate
    public void on(ClientCreatedEvent event){
        this.clientId = event.getId();
        this.nom = event.getNom();
        this.adresse = event.getAdresse();
        this.email = event.getEmail();
        this.tel = event.getTel();
    }
}
