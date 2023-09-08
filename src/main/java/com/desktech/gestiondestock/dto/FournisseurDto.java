package com.desktech.gestiondestock.dto;

import com.desktech.gestiondestock.model.Adresse;
import com.desktech.gestiondestock.model.CommandeFournisseur;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FournisseurDto {

    private Integer id;

    private String nom;

    private String prenom;

    private  String photo;

    private String email;

    private  String telephone;


    private AdresseDto addresse;

    @JsonIgnore
    private List<CommandeFournisseurDto> commandeFournisseurs;
}
