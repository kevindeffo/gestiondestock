package com.desktech.gestiondestock.mapper;

import com.desktech.gestiondestock.dto.CommandeFournisseurDto;
import com.desktech.gestiondestock.model.CommandeFournisseur;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommandeFournisseurMapper {
    CommandeFournisseurMapper INSTANCE = Mappers.getMapper(CommandeFournisseurMapper.class);

    CommandeFournisseurDto commandeFournisseurToDto(CommandeFournisseur commandeFournisseur);

    CommandeFournisseur DTOToEntity(CommandeFournisseurDto commandeFournisseurDto);

}
