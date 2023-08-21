package com.desktech.gestiondestock.dto;

import com.desktech.gestiondestock.model.Article;
import com.desktech.gestiondestock.model.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private Integer id;
    private String code;
    private String designation;

    @JsonIgnore
    private List<ArticleDto> articles;



    public CategoryDto fromEntity(Category category){

        if(category == null){
            return null;
//            TODO: throw an exception
        }

        return CategoryDto.builder()
                .id(category.getId())
                .code(category.getCode())
                .designation(category.getDesignation())
                .build();


    }

    public Category toEntity(CategoryDto categoryDto){
        if(categoryDto == null){
            return null;
//            TODO: throw an exception
        }
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setDesignation(categoryDto.getDesignation());
        category.setCode(categoryDto.getCode());

        return category;
    }
}
