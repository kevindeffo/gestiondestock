package com.desktech.gestiondestock.mapper;

import com.desktech.gestiondestock.dto.ArticleDto;
import com.desktech.gestiondestock.model.Article;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface ArticleMapper {
    ArticleDto articleToDto(Article article);

    Article DtoToArticle(ArticleDto articleDto);
}
