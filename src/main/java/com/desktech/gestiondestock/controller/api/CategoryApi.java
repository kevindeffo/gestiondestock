package com.desktech.gestiondestock.controller.api;

import com.desktech.gestiondestock.dto.CategoryDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.desktech.gestiondestock.utils.constants.APP_ROOT;

@Tag(name = "Category", description = "Categories End points")
public interface CategoryApi {

    @PostMapping(value = APP_ROOT +"/category/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto save(@RequestBody CategoryDto categoryDto);

    @GetMapping(value=APP_ROOT + "/category/{idCategory}",  produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findById(@PathVariable("idCategory") Integer id);


    @GetMapping(value=APP_ROOT + "/category/{codeCategory}",  produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findByCode(@PathVariable("codeCategory") String codeCategory);


    @GetMapping(value=APP_ROOT + "/category/all",  produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategoryDto> findAll();


    @DeleteMapping(value=APP_ROOT + "/category/delete/{idCategory}")
    void delete(@PathVariable("idCategory") Integer id);
}
