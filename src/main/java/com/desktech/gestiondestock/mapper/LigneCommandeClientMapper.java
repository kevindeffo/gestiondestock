package com.desktech.gestiondestock.mapper;

import com.desktech.gestiondestock.dto.LigneCommandeClientDto;
import com.desktech.gestiondestock.model.LigneCommandeClient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface LigneCommandeClientMapper {
    LigneCommandeClientMapper INSTANCE = Mappers.getMapper(LigneCommandeClientMapper.class);

    LigneCommandeClientDto ligneCommandeClientToDto(LigneCommandeClient ligneCommandeClient);

    LigneCommandeClient DTOToEntity(LigneCommandeClientDto ligneCommandeClientDto);
}
