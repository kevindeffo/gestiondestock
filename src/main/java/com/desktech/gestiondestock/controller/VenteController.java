package com.desktech.gestiondestock.controller;

import com.desktech.gestiondestock.controller.api.VentesApi;
import com.desktech.gestiondestock.dto.VentesDto;
import com.desktech.gestiondestock.services.VentesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VenteController implements VentesApi {

    private VentesService ventesService;

    @Autowired
    public VenteController(VentesService ventesService) {
        this.ventesService = ventesService;
    }

    @Override
    public VentesDto save(VentesDto ventesDto) {
        return ventesService.save(ventesDto);
    }

    @Override
    public VentesDto findById(Integer id) {
        return ventesService.findById(id);
    }

    @Override
    public VentesDto findByCode(String code) {
        return ventesService.findByCode(code);
    }

    @Override
    public List<VentesDto> findAll() {
        return ventesService.findAll();
    }

    @Override
    public void delete(Integer venteId) {
        ventesService.delete(venteId);
    }
}
