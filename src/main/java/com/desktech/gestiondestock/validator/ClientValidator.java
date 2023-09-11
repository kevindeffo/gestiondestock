package com.desktech.gestiondestock.validator;

import com.desktech.gestiondestock.dto.ClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {
    public static List<String> validate(ClientDto clientDto){
        List<String> errors = new ArrayList<>();
        if (clientDto == null){
            errors.add("Veuillez entrer le nom du client");
            errors.add("Veuillez entrer le numero de telephone du client");
        }else {
            if (!StringUtils.hasLength(clientDto.getNom())){
                errors.add("Veuillez entrer le nom du client");
            }

            if(!StringUtils.hasLength(clientDto.getTelephone())){
                errors.add("Veuillez entrer le numero de telephone du client");
            }
        }
        return errors;
    }
}
