package com.desktech.gestiondestock.controller.api;

import com.desktech.gestiondestock.dto.ClientDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.desktech.gestiondestock.utils.constants.APP_ROOT;

@Tag(name = "Client", description = "Client end point")
public interface ClientApi {

    @PostMapping(value = APP_ROOT +"/client/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto save(@RequestBody ClientDto clientDto);


    @GetMapping(value=APP_ROOT + "/client/{idClient}",  produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto findById(@PathVariable("idClient") Integer id);


    @GetMapping(value=APP_ROOT + "/client/all",  produces = MediaType.APPLICATION_JSON_VALUE)
    List<ClientDto> findAll();


    @DeleteMapping(value=APP_ROOT + "/client/delete/{idClient}")
    void delete(@PathVariable("idClient") Integer id);
}
