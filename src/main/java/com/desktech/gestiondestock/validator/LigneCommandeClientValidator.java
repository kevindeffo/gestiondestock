package com.desktech.gestiondestock.validator;

import com.desktech.gestiondestock.dto.LigneCommandeClientDto;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeClientValidator {

    public static List<String> validate(LigneCommandeClientDto dto){
        List<String> errors = new ArrayList<>();
            if (dto == null){

            }else {

            }
        return errors;
    }
}
