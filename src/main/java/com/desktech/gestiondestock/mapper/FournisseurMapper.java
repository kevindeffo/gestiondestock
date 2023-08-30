package com.desktech.gestiondestock.mapper;

import com.desktech.gestiondestock.dto.EntrepriseDto;
import com.desktech.gestiondestock.model.Entreprise;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface FournisseurMapper {

    EntrepriseMapper  INSTANCE = Mappers.getMapper(EntrepriseMapper.class);

    EntrepriseDto entrepriseToDto(Entreprise entreprise);
}
