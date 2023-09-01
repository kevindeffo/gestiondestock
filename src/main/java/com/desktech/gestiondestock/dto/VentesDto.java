package com.desktech.gestiondestock.dto;

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

    private String commentaire;

}
