package com.desktech.gestiondestock.mapper;

import com.desktech.gestiondestock.dto.MouvementStockDto;
import com.desktech.gestiondestock.model.MouvementStock;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface MouvementStockMapper {

    MouvementStockMapper INSTANCE = Mappers.getMapper(MouvementStockMapper.class);

    MouvementStockDto mouvementStockToDto(MouvementStock mouvementStock);

    MouvementStock DTOToEntity(MouvementStockDto mouvementStockDto);

}
