package com.example.inventoryservice.commands.aggregates;

import com.example.commonapi.commands.CreateClientCommand;
import com.example.commonapi.commands.CreateProduitCommand;
import com.example.commonapi.enums.EtatPdt;
import com.example.commonapi.events.ClientCreatedEvent;
import com.example.commonapi.events.ProduitCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class ProduitAggregate {
    @AggregateIdentifier
    private String pdtId;
    private String nom;
    private double prix;
    private double qte;
    private EtatPdt etat;

    public ProduitAggregate() {
        //Obligatoire par Axon
    }

    @CommandHandler
    public ProduitAggregate(CreateProduitCommand command){
        AggregateLifecycle.apply(new ProduitCreatedEvent(
                command.getId(),
                command.getNom(),
                command.getPrix(),
                command.getQte(),
                command.getEtat()
                ));
    }

    @EventSourcingHandler //émutter l'état de l'aggregate
    public void on(ProduitCreatedEvent event){
        this.pdtId = event.getId();
        this.nom = event.getNom();
        this.qte = event.getQte();
        this.prix = event.getPrix();
        this.etat = event.getEtat();
    }
}
