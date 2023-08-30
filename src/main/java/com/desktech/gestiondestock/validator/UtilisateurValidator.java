package com.desktech.gestiondestock.validator;

import com.desktech.gestiondestock.dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {
    public static List<String> validate(UtilisateurDto utilisateurDto){
        List<String> errors = new ArrayList<>();

        if(utilisateurDto == null){
            errors.add("Veuillez  renseigner le nom de l'utilisateur");
            errors.add("Veuillez  renseigner le prenom de l'utilisateur");
            errors.add("Veuillez  renseigner l'adresse email de l'utilisateur");
            errors.add("Veuillez renseigner le mot de passe de l'utilisateur");
            errors.add("Veuillez renseigner la ville de l'utilisateur");
            errors.add("Veuillez renseigner le pays l'utilisateur");
        }else {
            if (!StringUtils.hasLength(utilisateurDto.getNom())){
                errors.add("Veuillez  renseigner le nom de l'utilisateur");
            }

            if (!StringUtils.hasLength(utilisateurDto.getPrenom())){
                errors.add("Veuillez  renseigner le prenom de l'utilisateur");
            }

            if (!StringUtils.hasLength(utilisateurDto.getEmail())){
                errors.add("Veuillez  renseigner l'adresse email de l'utilisateur");
            }

            if (!StringUtils.hasLength(utilisateurDto.getMotDePasse())){
                errors.add("Veuillez renseigner le mot de passe de l'utilisateur");
            }

            if (!StringUtils.hasLength(utilisateurDto.getAdresse().getVille())){
                errors.add("Veuillez renseigner la ville de l'utilisateur");
            }

            if (!StringUtils.hasLength(utilisateurDto.getAdresse().getPays())){
                errors.add("Veuillez renseigner le pays l'utilisateur");
            }

            if (!StringUtils.hasLength(utilisateurDto.getAdresse().getAdresse1())){
                errors.add("Veuillez renseigner l'adresse l'utilisateur");
            }
        }

        return errors;
    }
}
