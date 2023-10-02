package com.desktech.gestiondestock.services.impl;

import com.desktech.gestiondestock.dto.EntrepriseDto;
import com.desktech.gestiondestock.enums.ErrorCodes;
import com.desktech.gestiondestock.exception.EntityNotFoundException;
import com.desktech.gestiondestock.exception.InvalidEntityException;
import com.desktech.gestiondestock.mapper.EntrepriseMapper;
import com.desktech.gestiondestock.repository.EntrepriseRepository;
import com.desktech.gestiondestock.services.EntrepriseService;
import com.desktech.gestiondestock.validator.EntrepriseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {


    EntrepriseRepository entrepriseRepository;

    @Autowired
    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository) {
        this.entrepriseRepository = entrepriseRepository;
    }

    @Override
    public EntrepriseDto save(EntrepriseDto entrepriseDto) {
        List<String> errors = EntrepriseValidator.validate(entrepriseDto);

        if(!errors.isEmpty()){
            log.error("Invalid Entreprise {}", entrepriseDto);
            throw new InvalidEntityException("Entreprise invalide", ErrorCodes.ENTREPRISE_NOT_VALID);
        }
        return EntrepriseMapper.INSTANCE.entrepriseToDto(entrepriseRepository.save(EntrepriseMapper.INSTANCE.DTOToEntity(entrepriseDto)));
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        if(id == null){
            log.error("Enterprise Id is null");
            return null;
        }


        return entrepriseRepository.findById(id).map(
                EntrepriseMapper.INSTANCE::entrepriseToDto
        ).orElseThrow(
                ()->new EntityNotFoundException("Aucune Entreprise ne correspond a cet Id", ErrorCodes.ENTREPRISE_NOT_FOUND)
        );
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseRepository.findAll().stream().map(
                EntrepriseMapper.INSTANCE::entrepriseToDto
        ).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Enterprise Id is null");
            return ;
        }

        entrepriseRepository.deleteById(id);
    }
}
