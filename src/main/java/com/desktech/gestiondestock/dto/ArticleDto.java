package com.desktech.gestiondestock.dto;


import com.desktech.gestiondestock.model.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDto {
    private Integer id;

    private String codeArticle;

    private String designation;

    private BigDecimal prixUnitaireHt;

    private BigDecimal tauxTva;

    private Integer idEntreprise;

    private BigDecimal prixUnitaireTtc;

    private String photo;

    private CategoryDto category;

//    public ArticleDto fromEntity(Article article){
//        if(article == null){
//            return null;
////            TODO: throw an exception
//        }
//        return ArticleDto.builder()
//                .id(article.getId())
//                .codeArticle(article.getCodeArticle())
//                .designation(article.getDesignation())
//                .prixUnitaireHt(article.getPrixUnitaireHt())
//                .tauxTva(article.getTauxTva())
//                .prixUnitaireTtc(article.getPrixUnitaireTtc())
//                .photo(article.getPhoto())
//                .category(new CategoryDto().fromEntity(article.getCategory()))
//                .build();
//    }
//
//    public Article toEntity(ArticleDto articleDto){
//        if(articleDto == null){
//            return null;
////            TODO: throw an exception
//        }
//
//        Article article = new Article();
//        article.setId(articleDto.getId());
//        article.setCodeArticle(articleDto.getCodeArticle());
//        article.setDesignation(articleDto.getDesignation());
//        article.setPrixUnitaireHt(articleDto.getPrixUnitaireHt());
//        article.setTauxTva(articleDto.getTauxTva());
//        article.setPrixUnitaireTtc(articleDto.getPrixUnitaireTtc());
//        article.setPhoto(articleDto.getPhoto());
//        return article;
//    }
}
