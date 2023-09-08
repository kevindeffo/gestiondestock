package com.desktech.gestiondestock.mapper;

import com.desktech.gestiondestock.dto.CommandeClientDto;
import com.desktech.gestiondestock.model.CommandeClient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommandeClientMapper {
    CommandeClientMapper INSTANCE = Mappers.getMapper(CommandeClientMapper.class);
    CommandeClientDto commandeClientToDto(CommandeClient commandeClient);

    CommandeClient DTOToEntity(CommandeClientDto commandeClientDto);
}
