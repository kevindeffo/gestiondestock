package com.desktech.gestiondestock.mapper;

import com.desktech.gestiondestock.dto.UtilisateurDto;
import com.desktech.gestiondestock.model.Utilisateur;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UtilisateursMapper {
    UtilisateursMapper INSTANCE = Mappers.getMapper(UtilisateursMapper.class);

    UtilisateurDto utilisateurToDto(Utilisateur utilisateur);

    Utilisateur DTOToEntity(UtilisateurDto utilisateurDto);
}
