package com.example.customerservice.query.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Client {
    @Id private String id;
    private String nom;
    private String adresse;
    private String email;
    private String tel;
}
