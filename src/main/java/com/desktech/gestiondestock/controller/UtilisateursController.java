package com.desktech.gestiondestock.controller;

import com.desktech.gestiondestock.controller.api.UtilisateursApi;
import com.desktech.gestiondestock.dto.UtilisateurDto;
import com.desktech.gestiondestock.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UtilisateursController implements UtilisateursApi {

    private final UtilisateurService utilisateurService;

    @Autowired
    public UtilisateursController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @Override
    public UtilisateurDto save(UtilisateurDto utilisateurDto) {
        return utilisateurService.save(utilisateurDto);
    }

    @Override
    public UtilisateurDto findById(Integer userId) {
        return utilisateurService.findById(userId);
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurService.findAll();
    }

    @Override
    public void delete(Integer userId) {
        utilisateurService.delete(userId);
    }
}
