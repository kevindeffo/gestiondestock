package com.desktech.gestiondestock.mapper;

import com.desktech.gestiondestock.dto.MouvementStockDto;
import com.desktech.gestiondestock.model.MouvementStock;
import org.mapstruct.factory.Mappers;

public interface MouvementStockMapper {

    MouvementStockMapper INSTANCE = Mappers.getMapper(MouvementStockMapper.class);

    MouvementStockDto mouvementStockToDto(MouvementStock mouvementStock);
}
