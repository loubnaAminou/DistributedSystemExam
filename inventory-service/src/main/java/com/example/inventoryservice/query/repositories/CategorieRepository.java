package com.example.inventoryservice.query.repositories;


import com.example.inventoryservice.query.entities.Categorie;
import com.example.inventoryservice.query.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, String> {
}
