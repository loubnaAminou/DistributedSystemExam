package com.example.commonapi.commands;

import com.example.commonapi.enums.EtatPdt;
import lombok.Getter;

public class CreateProduitCommand extends BaseCommand<String> {
    @Getter private String nom;
    @Getter private double prix;
    @Getter private double qte;
    @Getter private EtatPdt etat;

    public CreateProduitCommand(String id, String nom, double prix, double qte, EtatPdt etat) {
        super(id);
        this.nom = nom;
        this.prix = prix;
        this.qte = qte;
        this.etat = etat;
    }
}
