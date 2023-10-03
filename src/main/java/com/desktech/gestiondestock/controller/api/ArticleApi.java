package com.desktech.gestiondestock.controller.api;

import com.desktech.gestiondestock.dto.ArticleDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.desktech.gestiondestock.utils.constants.APP_ROOT;

@Api(APP_ROOT + "/articles")
public interface ArticleApi {
    @PostMapping(value = APP_ROOT +"/article/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto save(@RequestBody ArticleDto articleDto);

    @GetMapping(value=APP_ROOT + "/article/{idArticle}",  produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findById(@PathVariable("idArticle") Integer id);

    @GetMapping(value=APP_ROOT + "/article/{codeArticle}",  produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findByCode(@PathVariable("codeArticle") String code);

    @GetMapping(value=APP_ROOT + "/article/all",  produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDto> findAll();

    @DeleteMapping(value=APP_ROOT + "/article/delete/{idArticle}")
    void delete(@PathVariable("idArticle") Integer id);
}
