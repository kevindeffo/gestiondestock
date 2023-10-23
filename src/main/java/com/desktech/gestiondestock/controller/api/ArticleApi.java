package com.desktech.gestiondestock.controller.api;

import com.desktech.gestiondestock.dto.ArticleDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.desktech.gestiondestock.utils.constants.APP_ROOT;

@Tag(name = "Article", description = "Article endpoint")
public interface ArticleApi {
    @PostMapping(value = APP_ROOT +"/article/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Cette methode permet d'enregistrer ou de modifier un article ", responses = {@ApiResponse(responseCode = "200", description = "Objet article cree / modifie") })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Objet article cree / modifie"),
            @ApiResponse(responseCode = "400", description = "L'objet article est invalide")
    })
    ArticleDto save(@RequestBody ArticleDto articleDto);

    @GetMapping(value=APP_ROOT + "/article/{idArticle}",  produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Rechercher un article", description = "Cette methode permet de rechercher un article par son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Objet trouve en BDD"),
            @ApiResponse(responseCode = "404", description = "L'identifiant envoye ne correspond a aucun article"),
    })
    ArticleDto findById(@PathVariable("idArticle") Integer id);

    @GetMapping(value=APP_ROOT + "/article/{codeArticle}",  produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Rechercher un article", description = "Cette methode permet de rechercher un article par son code")
//    @Operation(summary = "Rechercher un article", description = "Cette methode permet de rechercher un article par son code", tags = {"article"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Objet trouve en BDD"),
            @ApiResponse(responseCode = "404", description = "Le code envoye ne correspond a aucun article"),
    })
    ArticleDto findByCode(@PathVariable("codeArticle") String code);

    @GetMapping(value=APP_ROOT + "/article/all",  produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Recuperer tous les article", description = "Cette methode permet de recuperer tous les article enregistre en BDD")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La liste des article "),
    })
    List<ArticleDto> findAll();

    @DeleteMapping(value=APP_ROOT + "/article/delete/{idArticle}")
    @Operation(summary = "Supprimer un article", description = "Cette methode permet de supprimer un article par son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "article supprime")
    })
    void delete(@PathVariable("idArticle") Integer id);
}
