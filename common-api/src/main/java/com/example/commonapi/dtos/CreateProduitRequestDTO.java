package com.example.commonapi.dtos;

import com.example.commonapi.enums.EtatPdt;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class CreateProduitRequestDTO {
    private String nom;
    private double prix;
    private double qte;
    private EtatPdt etat;
}
