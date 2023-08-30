package com.desktech.gestiondestock.validator;

import com.desktech.gestiondestock.dto.CategoryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {
    public static List<String> validate(CategoryDto categoryDto){
        List<String> errors = new ArrayList<>();

        if (categoryDto == null){
            errors.add("Veuillez entrer le code de la categorie");
            errors.add("Veuillez entrer la designation de la categorie");
        }else {
            if (!StringUtils.hasLength(categoryDto.getCode())){
                errors.add("Veuillez entrer le code de la categorie");
            }

            if (!StringUtils.hasLength(categoryDto.getDesignation())){
                errors.add("Veuillez entrer la designation de la categorie");
            }
        }

        return errors;
    }
}
