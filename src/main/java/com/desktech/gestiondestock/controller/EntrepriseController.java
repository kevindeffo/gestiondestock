package com.desktech.gestiondestock.controller;

import com.desktech.gestiondestock.controller.api.EntrepriseApi;
import com.desktech.gestiondestock.dto.EntrepriseDto;
import com.desktech.gestiondestock.services.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class EntrepriseController implements EntrepriseApi {
    private EntrepriseService entrepriseService;

    @Autowired
    public EntrepriseController(EntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

    @Override
    public EntrepriseDto save(EntrepriseDto entrepriseDto) {
        return entrepriseService.save(entrepriseDto);
    }

    @Override
    public EntrepriseDto findById(Integer entrepriseId) {
        return entrepriseService.findById(entrepriseId);
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseService.findAll();
    }

    @Override
    public void delete(Integer entrepriseId) {
        entrepriseService.delete(entrepriseId);
    }
}
