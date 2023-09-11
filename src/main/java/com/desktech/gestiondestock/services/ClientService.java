package com.desktech.gestiondestock.services;

import com.desktech.gestiondestock.dto.ClientDto;

import java.util.List;

public interface ClientService {
    ClientDto save(ClientDto clientDto);

    ClientDto findById(Integer id);

    List<ClientDto> findAll();

    void delete(Integer id);
}
