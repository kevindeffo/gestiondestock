package com.desktech.gestiondestock.validator;

import com.desktech.gestiondestock.dto.FournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FournisseurValitor {

    public static List<String> validate(FournisseurDto fournisseurDto){
        List<String> errors = new ArrayList<>();

        if (fournisseurDto == null){
            errors.add("Le nom du fournisseur est oblige");
            errors.add("Le numero de telephone du fournisseur est oblige");
        }else {
            if(!StringUtils.hasLength(fournisseurDto.getNom())){
                errors.add("Le nom du fournisseur est oblige");
            }
            if(!StringUtils.hasLength(fournisseurDto.getTelephone())){
                errors.add("Le numero de telephone du fournisseur est oblige");
            }
        }
        return errors;
    }


}
