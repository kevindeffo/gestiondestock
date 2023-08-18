package com.desktech.gestiondestock.dto;

import com.desktech.gestiondestock.model.Article;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Builder
@Data
public class CategoryDto {
    private Integer id;
    private String code;

    private String designation;


    private List<ArticleDto> articles;
}
