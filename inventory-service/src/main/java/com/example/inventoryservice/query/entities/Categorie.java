package com.example.inventoryservice.query.entities;

import com.example.commonapi.enums.EtatPdt;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Categorie {
    @Id
    private String id;
    private String nom;
    private String description;

    @OneToMany(mappedBy = "categorie")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Produit> produits = new ArrayList<>();
}
