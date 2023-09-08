package com.desktech.gestiondestock.mapper;

import com.desktech.gestiondestock.dto.ClientDto;
import com.desktech.gestiondestock.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientDto clientToDto(Client client);

    ClientDto DTOToEntity(ClientDto clientDto);
}
