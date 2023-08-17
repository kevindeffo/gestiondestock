package com.desktech.gestiondestock.model;

import com.desktech.gestiondestock.enums.TypeMouvementStock;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mouvementstock")
public class MouvementStock extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;

    @Column(name = "dateMouvement")
    private Instant dateMouvement;

    @Column(name = "quantite")
    private BigDecimal quantite;

    @Column(name = "typemouvementStock")
    private TypeMouvementStock typeMouvementStock;
}