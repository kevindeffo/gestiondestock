package com.desktech.gestiondestock.dto;

import com.desktech.gestiondestock.model.LigneVente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
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
public class VentesDto {


    private Integer id;

    private String code;

    private Instant dateVente;


    private String commentaire;
    private List<LigneVenteDto> ligneVentes;

}
