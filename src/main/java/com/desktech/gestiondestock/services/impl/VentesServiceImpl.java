package com.desktech.gestiondestock.services.impl;

import com.desktech.gestiondestock.dto.VentesDto;
import com.desktech.gestiondestock.enums.ErrorCodes;
import com.desktech.gestiondestock.exception.EntityNotFoundException;
import com.desktech.gestiondestock.exception.InvalidEntityException;
import com.desktech.gestiondestock.mapper.LigneVenteMapper;
import com.desktech.gestiondestock.mapper.VenteMapper;
import com.desktech.gestiondestock.model.Article;
import com.desktech.gestiondestock.model.LigneVente;
import com.desktech.gestiondestock.model.Ventes;
import com.desktech.gestiondestock.repository.ArticleRepository;
import com.desktech.gestiondestock.repository.LigneVenteRepository;
import com.desktech.gestiondestock.repository.VentesRepository;
import com.desktech.gestiondestock.services.VentesService;
import com.desktech.gestiondestock.validator.VentesValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VentesServiceImpl implements VentesService {

    ArticleRepository articleRepository;
    LigneVenteRepository ligneVenteRepository;
    VentesRepository ventesRepository;

    @Autowired
    public VentesServiceImpl(ArticleRepository articleRepository, LigneVenteRepository ligneVenteRepository, VentesRepository ventesRepository) {
        this.articleRepository = articleRepository;
        this.ligneVenteRepository = ligneVenteRepository;
        this.ventesRepository = ventesRepository;
    }

    @Override
    public VentesDto save(VentesDto dto) {
        List<String> errors = VentesValidator.validate(dto);

        if(!errors.isEmpty()){
            log.error("Invalid vent {}", dto);
            throw new InvalidEntityException("l'objet vente est  invalide", ErrorCodes.VENTE_NOT_VALID, errors);
        }
        List<String> articlesError = new ArrayList<>();
        dto.getLigneVentes().forEach(
              lignVenteDto->{
                  Optional<Article> article = articleRepository.findById(lignVenteDto.getArticle().getId());
                  if(article.isEmpty()){
                      articlesError.add("L'article avec l'ID " + lignVenteDto.getArticle().getId() + "n'existe pas en BDD");
                  }
              }
        );

        if(!articlesError.isEmpty()){
            log.warn("One or more article were not found in the DB, {}", articlesError);
            throw new InvalidEntityException("Article non existant en BDD", ErrorCodes.ARTICLE_NOT_FOUND, articlesError);
        }

        Ventes savedVente = ventesRepository.save(VenteMapper.INSTANCE.DTOToEntity(dto));

        dto.getLigneVentes().forEach(
                ligneVenteDto -> {
                    LigneVente ligneVente = LigneVenteMapper.INSTANCE.DTOToEntity(ligneVenteDto);
                    ligneVente.setVente(savedVente);
                    ligneVenteRepository.save(ligneVente);
                }
        );
        return VenteMapper.INSTANCE.venteToDto(savedVente);
    }

    @Override
    public VentesDto findById(Integer id) {
        if(id == null){
            log.error("Vente ID Null");
            return null;
        }
        return ventesRepository.findById(id).map(
                VenteMapper.INSTANCE::venteToDto
        ).orElseThrow(
                ()->     new EntityNotFoundException("Aucune vente ne correspond a l'id " + id, ErrorCodes.VENTE_NOT_FOUND)
        );
    }

    @Override
    public VentesDto findByCode(String code) {
        if(!StringUtils.hasLength(code)){
            log.error("The code of vente is null");
            return null;
        }
        return ventesRepository.findVentesByCode(code).map(
                VenteMapper.INSTANCE::venteToDto
        ).orElseThrow(
                ()->     new EntityNotFoundException("Aucune vente ne correspond au code " + code, ErrorCodes.VENTE_NOT_FOUND)
        );
    }

    @Override
    public List<VentesDto> findAll() {
        return ventesRepository.findAll().stream().map(
                VenteMapper.INSTANCE::venteToDto
        ).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Vente ID Null");
            return ;
        }

        ventesRepository.deleteById(id);
    }
}
