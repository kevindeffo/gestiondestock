package com.desktech.gestiondestock.services.impl;

import com.desktech.gestiondestock.dto.CommandeClientDto;
import com.desktech.gestiondestock.enums.ErrorCodes;
import com.desktech.gestiondestock.exception.EntityNotFoundException;
import com.desktech.gestiondestock.exception.InvalidEntityException;
import com.desktech.gestiondestock.mapper.CommandeClientMapper;
import com.desktech.gestiondestock.mapper.LigneCommandeClientMapper;
import com.desktech.gestiondestock.model.Article;
import com.desktech.gestiondestock.model.Client;
import com.desktech.gestiondestock.model.CommandeClient;
import com.desktech.gestiondestock.model.LigneCommandeClient;
import com.desktech.gestiondestock.repository.ArticleRepository;
import com.desktech.gestiondestock.repository.ClientRepository;
import com.desktech.gestiondestock.repository.CommandeClientRepository;
import com.desktech.gestiondestock.repository.LigneCommandeClientRepository;
import com.desktech.gestiondestock.services.CommandeClientService;
import com.desktech.gestiondestock.validator.CommandeClientValidator;
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
public class CommandeClientServiceImpl implements CommandeClientService {

    private CommandeClientRepository commandeClientRepository;
    private ArticleRepository articleRepository;
    private ClientRepository clientRepository;
    private LigneCommandeClientRepository ligneCommandeClientRepository;

    @Autowired
    public CommandeClientServiceImpl(CommandeClientRepository commandeClientRepository, ArticleRepository articleRepository, ClientRepository clientRepository, LigneCommandeClientRepository ligneCommandeClientRepository) {
        this.commandeClientRepository = commandeClientRepository;
        this.articleRepository = articleRepository;
        this.clientRepository = clientRepository;
        this.ligneCommandeClientRepository = ligneCommandeClientRepository;
    }

    @Override
    public CommandeClientDto save(CommandeClientDto commandeClientDto) {
        List<String> errors = CommandeClientValidator.validate(commandeClientDto);

        if(!errors.isEmpty()){
            log.error("Invalid Commande client {}", commandeClientDto);
            throw new InvalidEntityException("Commande client invalide", ErrorCodes.COMMANDE_CLIENT_NOT_VALID);
        }

        Optional<Client> client = clientRepository.findById(commandeClientDto.getClient().getId());

        if(client.isEmpty()){
            log.warn("Client with ID {} was not found in DB", commandeClientDto.getClient().getId());
            throw new EntityNotFoundException("Aucun client avec l'id " + commandeClientDto.getClient().getId() + "n'a ete trouve dans la BDD", ErrorCodes.CLIENT_NOT_FOUND);
        }
        List<String> articlesError = new ArrayList<>();

        if (commandeClientDto.getLigneCommandeClient() != null){
            commandeClientDto.getLigneCommandeClient().forEach(
                    lgncmdclt -> {
                        if (lgncmdclt.getArticle() != null){
                            Optional<Article> article = articleRepository.findById(lgncmdclt.getArticle().getId());
                            if(article.isEmpty()){
                                articlesError.add("L'article avec l'ID " + lgncmdclt.getArticle().getId() + "n'existe pas en BDD");
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

        CommandeClient savedCmdClt = commandeClientRepository.save(CommandeClientMapper.INSTANCE.DTOToEntity(commandeClientDto));
        commandeClientDto.getLigneCommandeClient().forEach(
                lgnCmdClt ->{
                    LigneCommandeClient ligneCommandeClient = LigneCommandeClientMapper.INSTANCE.DTOToEntity(lgnCmdClt);
                    ligneCommandeClient.setCommandeClient(savedCmdClt);
                    ligneCommandeClientRepository.save(ligneCommandeClient);
                }
        );
        return CommandeClientMapper.INSTANCE.commandeClientToDto(savedCmdClt);
    }

    @Override
    public CommandeClientDto findById(Integer id) {
        if(id == null){
            log.error("Null Commande client id");
            return null;
        }


        return commandeClientRepository.findById(id).map(
                CommandeClientMapper.INSTANCE::commandeClientToDto
        ).orElseThrow(()->new EntityNotFoundException("Aucune Commande client n'a ete trouve avec l'ID " + id, ErrorCodes.COMMANDE_CLIENT_NOT_FOUND));
    }

    @Override
    public CommandeClientDto findByCode(String code) {
        if(!StringUtils.hasLength(code)){
            log.error("Null Commande client code");
            return null;
        }
        return commandeClientRepository.findCommandeClientByCode(code).map(
                CommandeClientMapper.INSTANCE::commandeClientToDto
        ).orElseThrow(()->new EntityNotFoundException("Aucune Commande client n'a ete trouve avec le code " + code, ErrorCodes.COMMANDE_CLIENT_NOT_FOUND));
    }

    @Override
    public List<CommandeClientDto> findAll() {
        return commandeClientRepository.findAll().stream()
                .map(
                        CommandeClientMapper.INSTANCE::commandeClientToDto
                ).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Null Commande client id");
            return ;
        }

        commandeClientRepository.deleteById(id);
    }
}
