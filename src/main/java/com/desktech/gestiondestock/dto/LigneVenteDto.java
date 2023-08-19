package com.desktech.gestiondestock.dto;

import com.desktech.gestiondestock.model.Ventes;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class LigneVenteDto {

    private Integer id;

    private VentesDto vente;

    private BigDecimal quatite;

    private BigDecimal prixUnitaire;
}
