package com.desktech.gestiondestock.validator;

import com.desktech.gestiondestock.dto.ArticleDto;
import com.desktech.gestiondestock.dto.CategoryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {
    public static List<String> validate(ArticleDto articleDto){
        List<String> errors = new ArrayList<>();
            if(articleDto == null){
                errors.add("Veuillez entrer le code de l'aricle");
                return  errors;
            } else if(!StringUtils.hasLength(articleDto.getCodeArticle())){
                errors.add("Veuillez entrer le code de l'aricle");
            }
        return  errors;
    }
}
