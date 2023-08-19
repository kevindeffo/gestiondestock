package com.desktech.gestiondestock.dto;

import com.desktech.gestiondestock.enums.TypeMouvementStock;
import com.desktech.gestiondestock.model.Article;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Builder
@Data
public class MouvementStockDto {

    private Integer id;

    private ArticleDto article;

    private Instant dateMouvement;

    private BigDecimal quantite;

    private TypeMouvementStock typeMouvementStock;
}
