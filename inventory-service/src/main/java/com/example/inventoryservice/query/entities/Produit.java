package com.example.inventoryservice.query.entities;

import com.example.commonapi.enums.EtatPdt;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Produit {
    @Id
    private String id;
    private String nom;
    private double prix;
    private double qte;
    @Enumerated(EnumType.STRING)
    private EtatPdt etat;
    @ManyToOne
    private Categorie categorie;
}
