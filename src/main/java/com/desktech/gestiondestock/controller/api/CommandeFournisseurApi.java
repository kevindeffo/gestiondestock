package com.desktech.gestiondestock.controller.api;

import com.desktech.gestiondestock.dto.CommandeFournisseurDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.desktech.gestiondestock.utils.constants.APP_ROOT;

@Tag(name = "Commande Fournisseur", description = "Commande fournisseur end point")
public interface CommandeFournisseurApi {
    @PostMapping(APP_ROOT + "/commandesfournisseurs/create")
    ResponseEntity<CommandeFournisseurDto> save(@RequestBody CommandeFournisseurDto dto);

    @GetMapping(APP_ROOT + "/commandesfournisseurs/{idCommande}")
    ResponseEntity<CommandeFournisseurDto> findById(@PathVariable Integer idCommande);

    @GetMapping(APP_ROOT + "/commandesfournisseurs/{codeCommande}")
    ResponseEntity<CommandeFournisseurDto> findByCode(@PathVariable String code);

    @GetMapping(APP_ROOT + "/commandesfournisseurs/all")
    ResponseEntity<List<CommandeFournisseurDto>> findAll();

    @DeleteMapping(APP_ROOT + "/commandesfournisseurs/delete/{idCommande}")
    ResponseEntity delete(@PathVariable Integer idCommande);
}
