package com.desktech.gestiondestock.validator;

import com.desktech.gestiondestock.dto.EntrepriseDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EntrepriseValidator {
    public static List<String> validate(EntrepriseDto entrepriseDto){
        List<String> errors = new ArrayList<>();

        if(entrepriseDto == null){
            errors.add("Le nom de l'entreprise est obligatoire");
            errors.add("Le numero de telephone de l'entreprise est obligatoire");
        }else {
            if(!StringUtils.hasLength(entrepriseDto.getNom())){
                errors.add("Le nom de l'entreprise est obligatoire");
            }

            if (!StringUtils.hasLength(entrepriseDto.getNumTel())){
                errors.add("Le numero de telephone de l'entreprise est obligatoire");
            }
        }
        return errors;
    }
}
