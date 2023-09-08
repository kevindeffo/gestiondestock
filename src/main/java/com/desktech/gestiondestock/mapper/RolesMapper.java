package com.desktech.gestiondestock.mapper;

import com.desktech.gestiondestock.dto.RolesDto;
import com.desktech.gestiondestock.model.Roles;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RolesMapper {

    RolesMapper INSTANCE = Mappers.getMapper(RolesMapper.class);

    RolesDto rolesToDto(Roles roles);

    Roles DTOToEntity(RolesDto rolesDto);
}
