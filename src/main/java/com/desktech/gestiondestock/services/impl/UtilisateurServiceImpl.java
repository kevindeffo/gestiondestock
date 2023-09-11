package com.desktech.gestiondestock.services.impl;

import com.desktech.gestiondestock.dto.UtilisateurDto;
import com.desktech.gestiondestock.enums.ErrorCodes;
import com.desktech.gestiondestock.exception.EntityNotFoundException;
import com.desktech.gestiondestock.mapper.UtilisateursMapper;
import com.desktech.gestiondestock.repository.UtilisateurRepository;
import com.desktech.gestiondestock.services.UtilisateurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {

    UtilisateurRepository utilisateurRepository;

    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UtilisateurDto save(UtilisateurDto utilisateurDto) {
        if (utilisateurDto == null){
            log.error("Utilisateur null {}", utilisateurDto);
        }
        return UtilisateursMapper.INSTANCE.utilisateurToDto(utilisateurRepository.save(UtilisateursMapper.INSTANCE.DTOToEntity(utilisateurDto)));
    }


    @Override
    public UtilisateurDto findById(Integer id) {

        if (id == null){
            log.error("l'Id de l'utilisateur est null");
            return null;
        }
        return utilisateurRepository.findById(id).map(
                UtilisateursMapper.INSTANCE::utilisateurToDto
        ).orElseThrow(
                ()-> new EntityNotFoundException("Aucun utilisateur ne correspond a l'id "+id, ErrorCodes.UTILISATEUR_NOT_FOUND)
        );
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurRepository.findAll().stream().map(
                UtilisateursMapper.INSTANCE::utilisateurToDto
        ).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("l'Id de l'utilisateur est null");
            return ;
        }
        utilisateurRepository.deleteById(id);
    }
}
