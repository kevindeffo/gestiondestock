package com.desktech.gestiondestock.mapper;

import com.desktech.gestiondestock.dto.LigneVenteDto;
import com.desktech.gestiondestock.model.LigneVente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface LigneVenteMapper {
    LigneVenteMapper INSTANCE = Mappers.getMapper(LigneVenteMapper.class);

    LigneVenteDto ligneVenteToDto(LigneVente ligneVente);

    LigneVente DTOToEntity(LigneVenteDto ligneVenteDto);
}
