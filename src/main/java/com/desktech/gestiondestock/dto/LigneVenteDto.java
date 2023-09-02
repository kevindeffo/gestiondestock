package com.desktech.gestiondestock.dto;

import com.desktech.gestiondestock.model.Ventes;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LigneVenteDto {

    private Integer id;

    private BigDecimal quatite;

    private BigDecimal prixUnitaire;

    private VentesDto vente;
}
