package com.desktech.gestiondestock.controller.api;

import com.desktech.gestiondestock.dto.EntrepriseDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import static com.desktech.gestiondestock.utils.constants.ENTREPRISES_END_POINT;

@Tag(name = "Entreprise", description = "Entreprise end point")
public interface EntrepriseApi {
    @PostMapping(ENTREPRISES_END_POINT + "/create")
    EntrepriseDto save(EntrepriseDto entrepriseDto);

    @GetMapping(ENTREPRISES_END_POINT + "/{entrepriseId}")
    EntrepriseDto findById(@PathVariable Integer entrepriseId);

    @GetMapping(ENTREPRISES_END_POINT + "/all")
    List<EntrepriseDto> findAll();

    @DeleteMapping(ENTREPRISES_END_POINT + "/delete/{entrepriseId}")
    void delete(@PathVariable Integer entrepriseId);
}
