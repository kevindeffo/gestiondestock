package com.desktech.gestiondestock.controller.api;

import com.desktech.gestiondestock.dto.CommandeClientDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import static com.desktech.gestiondestock.utils.constants.APP_ROOT;

@Tag(name = "Commande Client", description = "Commande client end point")
public interface CommandeClientApi {
    @PostMapping(APP_ROOT + "/commandesclients/create")
    ResponseEntity<CommandeClientDto> save(CommandeClientDto commandeClientDto);
    @GetMapping(APP_ROOT + "/commandesclients/{idCommandeClient}")
    ResponseEntity<CommandeClientDto> findById(@PathVariable Integer idCommandeClient);

    @GetMapping(APP_ROOT + "/commandesclients/{codeCommandeClient}")
    ResponseEntity<CommandeClientDto> findByCode(@PathVariable("codeCommandeClient") String code);

    @GetMapping(APP_ROOT + "/commandesclients/all")
    ResponseEntity<List<CommandeClientDto>> findAll();

    @DeleteMapping(APP_ROOT + "/commandesclients/delete/{idCommandeClient}")
    ResponseEntity delete(@PathVariable("idCommandeClient") Integer id);
}
