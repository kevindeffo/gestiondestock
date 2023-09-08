package com.desktech.gestiondestock.mapper;

import com.desktech.gestiondestock.dto.CategoryDto;
import com.desktech.gestiondestock.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
    CategoryDto categoryToDto(Category category);

    Category DTOToEntity(CategoryDto categoryDto);
}
