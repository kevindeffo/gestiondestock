package com.desktech.gestiondestock.controller;

import com.desktech.gestiondestock.controller.api.ArticleApi;
import com.desktech.gestiondestock.dto.ArticleDto;
import com.desktech.gestiondestock.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController  implements ArticleApi {

    private ArticleService articleService;
    @Autowired
    public ArticleController(ArticleService articleService){
        this.articleService = articleService;
    }
    @Override
    public ArticleDto save(ArticleDto articleDto) {
        return articleService.save(articleDto);
    }

    @Override
    public ArticleDto findById(Integer id) {
        return articleService.findById(id);
    }

    @Override
    public ArticleDto findByCode(String code) {
        return articleService.findByCode(code);
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleService.findAll();
    }

    @Override
    public void delete(Integer id) {
        articleService.delete(id);
    }
}
