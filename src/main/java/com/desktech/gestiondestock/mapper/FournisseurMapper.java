package com.desktech.gestiondestock.mapper;

import com.desktech.gestiondestock.dto.EntrepriseDto;
import com.desktech.gestiondestock.dto.FournisseurDto;
import com.desktech.gestiondestock.model.Entreprise;
import com.desktech.gestiondestock.model.Fournisseur;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface FournisseurMapper {

    FournisseurMapper  INSTANCE = Mappers.getMapper(FournisseurMapper.class);

    FournisseurDto fournisseurToDto(Fournisseur fournisseur);

    Fournisseur DTOToEntity(FournisseurDto fournisseurDto);
}
