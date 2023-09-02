package com.desktech.gestiondestock.dto;

import com.desktech.gestiondestock.enums.TypeMouvementStock;
import com.desktech.gestiondestock.model.Article;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MouvementStockDto {

    private Integer id;


    private Instant dateMouvement;

    private BigDecimal quantite;

    private ArticleDto article;
//    private TypeMouvementStockDto typeMouvementStock;
}
