package com.desktech.gestiondestock.services.impl;

import com.desktech.gestiondestock.dto.FournisseurDto;
import com.desktech.gestiondestock.enums.ErrorCodes;
import com.desktech.gestiondestock.exception.EntityNotFoundException;
import com.desktech.gestiondestock.exception.InvalidEntityException;
import com.desktech.gestiondestock.mapper.FournisseurMapper;
import com.desktech.gestiondestock.repository.FournisseurRepository;
import com.desktech.gestiondestock.services.FournisseurService;
import com.desktech.gestiondestock.validator.FournisseurValitor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FournisseurServiceImpl implements FournisseurService {

    FournisseurRepository fournisseurRepository;

    public FournisseurServiceImpl(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    @Override
    public FournisseurDto save(FournisseurDto fournisseurDto) {
        List<String> errors = FournisseurValitor.validate(fournisseurDto);

        if(!errors.isEmpty()){
            log.error("Invalid Fournisseur {}", fournisseurDto);
            throw new InvalidEntityException("Fournisseur invalide", ErrorCodes.FOURNISSEUR_NOT_VALID);
        }
        return FournisseurMapper.INSTANCE.fournisseurToDto(fournisseurRepository.save(FournisseurMapper.INSTANCE.DTOToEntity(fournisseurDto)));
    }

    @Override
    public FournisseurDto findById(Integer id) {
        if(id == null){
            log.error("Fournisseur Id is null");
            return null;
        }
        return fournisseurRepository.findById(id).map(
                FournisseurMapper.INSTANCE::fournisseurToDto
        ).orElseThrow(
                ()-> new EntityNotFoundException("Auncun fournisseur ne correspond a  l'id "+id, ErrorCodes.FOURNISSEUR_NOT_FOUND)
        );
    }

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurRepository.findAll().stream().map(
                FournisseurMapper.INSTANCE::fournisseurToDto
        ).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Fournisseur Id is null");
            return;
        }

        fournisseurRepository.deleteById(id);
    }
}
