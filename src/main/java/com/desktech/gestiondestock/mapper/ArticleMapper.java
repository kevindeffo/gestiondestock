package com.desktech.gestiondestock.mapper;

import com.desktech.gestiondestock.dto.ArticleDto;
import com.desktech.gestiondestock.model.Article;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;


@Mapper()
public interface ArticleMapper {

    ArticleMapper INSTANCE = Mappers.getMapper(ArticleMapper.class);
    ArticleDto articleToDto(Article article);

    Article DtoToArticle(ArticleDto articleDto);
}
