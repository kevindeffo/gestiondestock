package com.desktech.gestiondestock.mapper;

import com.desktech.gestiondestock.dto.AdresseDto;
import com.desktech.gestiondestock.model.Adresse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdresseMapper {
    AdresseMapper INSTANCE = Mappers.getMapper(AdresseMapper.class);
    AdresseDto adressToDto(Adresse adresse);
}
