package com.desktech.gestiondestock.services.impl;

import com.desktech.gestiondestock.dto.ArticleDto;
import com.desktech.gestiondestock.enums.ErrorCodes;
import com.desktech.gestiondestock.exception.EntityNotFoundException;
import com.desktech.gestiondestock.exception.InvalidEntityException;
import com.desktech.gestiondestock.mapper.ArticleMapper;
import com.desktech.gestiondestock.model.Article;
import com.desktech.gestiondestock.repository.ArticleRepository;
import com.desktech.gestiondestock.services.ArticleService;
import com.desktech.gestiondestock.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j //Logging
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl( ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleDto save(ArticleDto articleDto) {
        List<String> errors = ArticleValidator.validate(articleDto);
        if(!errors.isEmpty()){
            log.error("Article is not valid {}", articleDto);
            throw new InvalidEntityException("The Entity is not valid", ErrorCodes.ARTICLE_NOT_VALIDE, errors);
        }
        return ArticleMapper.INSTANCE.articleToDto(articleRepository.save(ArticleMapper.INSTANCE.DtoToArticle(articleDto)));
    }

    @Override
    public ArticleDto findById(Integer id) {
        if(id == null){
            log.error("Null id");
            return null;
        }

        Optional<Article> article = articleRepository.findById(id);


//        ArticleDto articleDto = ArticleMapper.INSTANCE.articleToDto(article.get());

        return Optional.of(ArticleMapper.INSTANCE.articleToDto(article.get())).orElseThrow(
                ()->new EntityNotFoundException("Aucun article ne correspond a l' ID "+id, ErrorCodes.ARTICLE_NOT_FOUND)
        );
    }

    @Override
    public ArticleDto findByCode(String code) {

        if(code == null){
            log.error("Null codeArticle");
            return null;
        }

        Optional<Article> article = articleRepository.findArticleByCodeArticle(code);


        ArticleDto articleDto = ArticleMapper.INSTANCE.articleToDto(article.get());

        return Optional.of(ArticleMapper.INSTANCE.articleToDto(article.get())).orElseThrow(
                ()->new EntityNotFoundException("Aucun article ne correspond au code "+code, ErrorCodes.ARTICLE_NOT_FOUND)
        );
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream()
                .map(ArticleMapper.INSTANCE::articleToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Null id");
            return;
        }

        articleRepository.deleteById(id);
    }
}
