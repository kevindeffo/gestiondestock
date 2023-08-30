package com.desktech.gestiondestock.mapper;

import com.desktech.gestiondestock.dto.VentesDto;
import com.desktech.gestiondestock.model.Ventes;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface VenteMapper {

    VenteMapper INSTANCE = Mappers.getMapper(VenteMapper.class);

    VentesDto venteToDto(Ventes ventes);
}
