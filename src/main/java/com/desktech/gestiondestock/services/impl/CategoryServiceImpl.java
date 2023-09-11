package com.desktech.gestiondestock.services.impl;

import com.desktech.gestiondestock.dto.CategoryDto;
import com.desktech.gestiondestock.enums.ErrorCodes;
import com.desktech.gestiondestock.exception.EntityNotFoundException;
import com.desktech.gestiondestock.exception.InvalidEntityException;
import com.desktech.gestiondestock.mapper.CategoryMapper;
import com.desktech.gestiondestock.model.Category;
import com.desktech.gestiondestock.repository.CategoryRepository;
import com.desktech.gestiondestock.services.CategoryService;
import com.desktech.gestiondestock.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        List<String> errors = CategoryValidator.validate(categoryDto);

        if(!errors.isEmpty()){
            log.error("Category is not valid {}", categoryDto);
            throw new InvalidEntityException("Entity is not valid", ErrorCodes.CATEGORY_NOT_VALID, errors);
        }
        return CategoryMapper.INSTANCE.categoryToDto(categoryRepository.save(CategoryMapper.INSTANCE.DTOToEntity(categoryDto)));
    }

    @Override
    public CategoryDto findById(Integer id) {
        if(id == null){
            log.error("Null id");
            return null;
        }

        Optional<Category> category = categoryRepository.findById(id);
//        return Optional.of(CategoryMapper.INSTANCE.categoryToDto(category.get())).orElseThrow(
//                ()->new EntityNotFoundException("Aucune Categorie ne correspond a l'ID "+id, ErrorCodes.CATEGORY_NOT_FOUND)
//        );

        return category.map(
              CategoryMapper.INSTANCE::categoryToDto
        ).orElseThrow(
               ()->new EntityNotFoundException("Aucune Categorie ne correspond a l'ID "+id, ErrorCodes.CATEGORY_NOT_FOUND)
       );
    }

    @Override
    public CategoryDto findByCode(String code) {
        if(StringUtils.hasLength(code)){
            log.error("Null code");
            return null;
        }

        Optional<Category> category = categoryRepository.findCategoryByCode(code);
        return Optional.of(CategoryMapper.INSTANCE.categoryToDto(category.get())).orElseThrow(
                ()->new EntityNotFoundException("Aucune Categorie ne correspond au code "+code, ErrorCodes.CATEGORY_NOT_FOUND)
        );
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream().map(
                CategoryMapper.INSTANCE::categoryToDto
        ).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Null id");
            return;
        }
        categoryRepository.deleteById(id);
    }
}
