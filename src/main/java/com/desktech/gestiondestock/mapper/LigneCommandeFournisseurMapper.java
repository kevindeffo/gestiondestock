package com.desktech.gestiondestock.mapper;

import com.desktech.gestiondestock.dto.LigneCommandeFournisseurDto;
import com.desktech.gestiondestock.model.LigneCommandeFournisseur;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface LigneCommandeFournisseurMapper {
    LigneCommandeFournisseurMapper INSTANCE = Mappers.getMapper(LigneCommandeFournisseurMapper.class);

    LigneCommandeFournisseurDto ligneCommandeFournisseurToDto(LigneCommandeFournisseur ligneCommandeFournisseur);
}
