package com.example.inventoryservice.query.repositories;


import com.example.inventoryservice.query.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, String> {
}
