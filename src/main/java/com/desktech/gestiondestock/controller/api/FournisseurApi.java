package com.desktech.gestiondestock.controller.api;

import com.desktech.gestiondestock.dto.FournisseurDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.desktech.gestiondestock.utils.constants.APP_ROOT;
import static com.desktech.gestiondestock.utils.constants.FOURNISSEURS_END_POINT;

@Tag(name = "Fournisseur", description = "Fournisseur End point")
public interface FournisseurApi {
    @PostMapping(FOURNISSEURS_END_POINT + "/create")
    FournisseurDto save(@RequestBody FournisseurDto fournisseurDto);
    @GetMapping(FOURNISSEURS_END_POINT + "/{fournisseurId}")
    FournisseurDto findById(@PathVariable("fournisseurId") Integer id);
    @GetMapping(FOURNISSEURS_END_POINT + "/all")
    List<FournisseurDto> findAll();

    @DeleteMapping(FOURNISSEURS_END_POINT + "/{fournisseurId}")
    void delete(@PathVariable Integer fournisseurId);
}
