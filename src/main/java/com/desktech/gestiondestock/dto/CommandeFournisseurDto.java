package com.desktech.gestiondestock.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommandeFournisseurDto {

    private Integer id;

    private String code;

    private Instant dateCommande;

    private FournisseurDto fournisseur;


    private List<LigneCommandeFournisseurDto> ligneCommandeFournisseur;
}
