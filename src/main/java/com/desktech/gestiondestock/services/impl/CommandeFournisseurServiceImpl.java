package com.desktech.gestiondestock.services.impl;

import com.desktech.gestiondestock.dto.CommandeFournisseurDto;
import com.desktech.gestiondestock.dto.FournisseurDto;
import com.desktech.gestiondestock.enums.ErrorCodes;
import com.desktech.gestiondestock.exception.EntityNotFoundException;
import com.desktech.gestiondestock.exception.InvalidEntityException;
import com.desktech.gestiondestock.mapper.CommandeFournisseurMapper;
import com.desktech.gestiondestock.mapper.LigneCommandeFournisseurMapper;
import com.desktech.gestiondestock.model.Article;
import com.desktech.gestiondestock.model.CommandeFournisseur;
import com.desktech.gestiondestock.model.Fournisseur;
import com.desktech.gestiondestock.model.LigneCommandeFournisseur;
import com.desktech.gestiondestock.repository.ArticleRepository;
import com.desktech.gestiondestock.repository.CommandeFournisseurRepository;
import com.desktech.gestiondestock.repository.FournisseurRepository;
import com.desktech.gestiondestock.repository.LigneCommandeFournisseurRepository;
import com.desktech.gestiondestock.services.CommandeFournisseurService;
import com.desktech.gestiondestock.validator.CommandeFournisseurValidator;
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
public class CommandeFournisseurServiceImpl implements CommandeFournisseurService {

    CommandeFournisseurRepository commandeFournisseurRepository;
    LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository;
    ArticleRepository articleRepository;
    FournisseurRepository fournisseurRepository;

    @Autowired
    public CommandeFournisseurServiceImpl(CommandeFournisseurRepository commandeFournisseurRepository, LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository, ArticleRepository articleRepository, FournisseurRepository fournisseurRepository) {
        this.commandeFournisseurRepository = commandeFournisseurRepository;
        this.ligneCommandeFournisseurRepository = ligneCommandeFournisseurRepository;
        this.articleRepository = articleRepository;
        this.fournisseurRepository = fournisseurRepository;
    }

    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto dto) {
        List<String> errors = CommandeFournisseurValidator.validate(dto);

        if(!errors.isEmpty()){
            log.error("Invalid Commande Fournisseur {}", dto);
            throw new InvalidEntityException("Commande fournisseur invalide", ErrorCodes.FOURNISSEUR_NOT_VALID, errors);
        }

        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(dto.getFournisseur().getId());

        if(fournisseur.isEmpty()){
            log.warn("Fournisseur with ID {} was not found in DB", dto.getFournisseur().getId());
            throw new EntityNotFoundException("Aucun Fournisseur avec l'ID " + dto.getFournisseur().getId() + "n'a ete trouve en BDD", ErrorCodes.FOURNISSEUR_NOT_FOUND);
        }

        List<String> articlesError = new ArrayList<>();

        if(dto.getLigneCommandeFournisseur() != null){
            dto.getLigneCommandeFournisseur().forEach(
                    lgnCmdFnsr->{
                        if(lgnCmdFnsr.getArticle() != null){
                            Optional<Article> article = articleRepository.findById(lgnCmdFnsr.getArticle().getId());
                            if(article.isEmpty()){
                                articlesError.add("L'article avec l'ID " + lgnCmdFnsr.getArticle().getId() + "n'existe pas en BDD");
                            }
                        }else {
                            articlesError.add("Impossible d'enregistrer une commande avec un article NULL");
                        }
                    }
            );
        }

        if(!articlesError.isEmpty()){
            log.warn("Article non existant en BDD {}", articlesError);
            throw new InvalidEntityException("Article non existant en BDD", ErrorCodes.ARTICLE_NOT_FOUND, articlesError);
        }

        CommandeFournisseur savedCommand = commandeFournisseurRepository.save(CommandeFournisseurMapper.INSTANCE.DTOToEntity(dto));
        dto.getLigneCommandeFournisseur().forEach(
                lgnCmdFnsr->{
                    LigneCommandeFournisseur ligneCommandeFournisseur = LigneCommandeFournisseurMapper.INSTANCE.DTOToEntity(lgnCmdFnsr);
                    ligneCommandeFournisseur.setCommandeFournisseur(savedCommand);
                    ligneCommandeFournisseurRepository.save(ligneCommandeFournisseur);
                }
        );
        return CommandeFournisseurMapper.INSTANCE.commandeFournisseurToDto(savedCommand);
    }

    @Override
    public CommandeFournisseurDto findById(Integer id) {
        if(id == null){
            log.error("Null Commande Fournisseur id");
            return null;
        }
        return commandeFournisseurRepository.findById(id).map(
                CommandeFournisseurMapper.INSTANCE::commandeFournisseurToDto
        ).orElseThrow(
                ()->new EntityNotFoundException("Aucune commande n'a ete trouve avec l'id " + id, ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND)
        );
    }

    @Override
    public CommandeFournisseurDto findByCode(String code) {
        if(!StringUtils.hasLength(code)){
            log.error("Null Commande Fournisseur code");
            return null;
        }
        return commandeFournisseurRepository.findCommandeFournisseurByCode(code).map(
                CommandeFournisseurMapper.INSTANCE::commandeFournisseurToDto
        ).orElseThrow(
                ()->new EntityNotFoundException("Aucune commande n'a ete trouve avec l'id " + code, ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND)
        );
    }

    @Override
    public List<CommandeFournisseurDto> findAll() {
        return commandeFournisseurRepository.findAll().stream().map(
                CommandeFournisseurMapper.INSTANCE::commandeFournisseurToDto
        ).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Null Commande Fournisseur id");
            return;
        }

        commandeFournisseurRepository.deleteById(id);
    }
}
