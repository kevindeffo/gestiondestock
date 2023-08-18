package com.desktech.gestiondestock.dto;

import com.desktech.gestiondestock.model.Adresse;
import com.desktech.gestiondestock.model.CommandeFournisseur;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class FournisseurDto {

    private Integer id;

    private String nom;

    private String prenom;

    private  String photo;

    private String email;

    private  String telephone;


    AdresseDto addresse;

    private List<CommandeFournisseurDto> commandeFournisseurs;
}
