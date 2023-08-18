package com.desktech.gestiondestock.dto;

import com.desktech.gestiondestock.model.Adresse;
import com.desktech.gestiondestock.model.CommandeClient;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ClientDto {

    private Integer id;

    private String nom;

    private String prenom;

    private  String photo;


    private String email;

    private  String telephone;

    private AdresseDto addresse;

    private List<CommandeClientDto> commandeClients;
}
