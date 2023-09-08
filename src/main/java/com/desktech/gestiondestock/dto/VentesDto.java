package com.desktech.gestiondestock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VentesDto {


    private Integer id;

    private String code;

    private Instant dateVente;

    @JsonIgnore
    private String commentaire;

}
