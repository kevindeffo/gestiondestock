package com.desktech.gestiondestock.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lignevente")
@Builder
public class LigneVente extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "idvente")
    private  Ventes vente;

    @Column(name = "quantite")
    private BigDecimal quatite;

    @Column(columnDefinition = "prixUnitaire")
    private BigDecimal prixUnitaire;
}
