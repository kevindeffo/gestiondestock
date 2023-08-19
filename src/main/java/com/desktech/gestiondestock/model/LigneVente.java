package com.desktech.gestiondestock.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lignevente")
@Builder
public class LigneVente extends AbstractEntity{

    @Column(name = "quantite")
    private BigDecimal quatite;

    @Column(name = "prixUnitaire")
    private BigDecimal prixUnitaire;

    @ManyToOne
    @JoinColumn(name = "idvente")
    private  Ventes vente;
}
