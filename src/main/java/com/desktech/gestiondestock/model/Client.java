package com.desktech.gestiondestock.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "client")
public class Client extends AbstractEntity {

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "photo")
    private  String photo;

    @Column(name = "email")
    private String email;

    @Column(name = "telephone")
    private  String telephone;

    @Embedded
    private  Adresse addresse;

    @OneToMany(mappedBy = "client")
    List<CommandeClient> commandeClients;
}
