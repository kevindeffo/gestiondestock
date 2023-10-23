package com.desktech.gestiondestock.controller.api;

import com.desktech.gestiondestock.dto.VentesDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.desktech.gestiondestock.utils.constants.VENTES_END_POINT;

@Tag(name = "Ventes", description = "Ventes End points")
public interface VentesApi {

    @PostMapping(VENTES_END_POINT + "/create")
    VentesDto save(@RequestBody VentesDto ventesDto);

    @GetMapping(VENTES_END_POINT + "/{venteId}")
    VentesDto findById(@PathVariable("venteId") Integer id);
    @GetMapping(VENTES_END_POINT + "/{venteCode}")
    VentesDto findByCode(@PathVariable("venteCode") String code);
    @GetMapping(VENTES_END_POINT + "/all")
    List<VentesDto> findAll();

    @DeleteMapping(VENTES_END_POINT + "/delete/{venteId}")
    void delete(@PathVariable Integer venteId);
}
