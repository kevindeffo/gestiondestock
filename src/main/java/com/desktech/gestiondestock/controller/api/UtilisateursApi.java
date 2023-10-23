package com.desktech.gestiondestock.controller.api;

import com.desktech.gestiondestock.dto.UtilisateurDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.desktech.gestiondestock.utils.constants.UTILISATEURS_EN_POINT;

@Tag(name = "Utilisateur", description = "Utilisateurs End points")
public interface UtilisateursApi {
    @PostMapping(UTILISATEURS_EN_POINT + "/create")
    UtilisateurDto save(@RequestBody UtilisateurDto utilisateurDto);

    @GetMapping(UTILISATEURS_EN_POINT + "/{userId}")
    UtilisateurDto findById(@PathVariable Integer userId);

    @GetMapping(UTILISATEURS_EN_POINT + "/all")
    List<UtilisateurDto> findAll();

    @DeleteMapping(UTILISATEURS_EN_POINT + "/{userId}")
    void delete(@PathVariable Integer userId);
}
