package com.desktech.gestiondestock.services.impl;

import com.desktech.gestiondestock.dto.ClientDto;
import com.desktech.gestiondestock.enums.ErrorCodes;
import com.desktech.gestiondestock.exception.EntityNotFoundException;
import com.desktech.gestiondestock.exception.InvalidEntityException;
import com.desktech.gestiondestock.mapper.ClientMapper;
import com.desktech.gestiondestock.model.Client;
import com.desktech.gestiondestock.repository.ClientRepository;
import com.desktech.gestiondestock.services.ClientService;
import com.desktech.gestiondestock.validator.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    ClientRepository clientRepository;
    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }
    @Override
    public ClientDto save(ClientDto clientDto) {
        List<String> errors = ClientValidator.validate(clientDto);

        if (!errors.isEmpty()){
            log.error("Client is is not valid {}", clientDto);
            throw new InvalidEntityException("Entity is not valid", ErrorCodes.CLIENT_NOT_VALID, errors);
        }

        return ClientMapper.INSTANCE.clientToDto(clientRepository.save(ClientMapper.INSTANCE.DTOToEntity(clientDto)));
    }

    @Override
    public ClientDto findById(Integer id) {
        if(id == null){
            log.error("Null id");
            return null;
        }

        return clientRepository.findById(id).map(
                ClientMapper.INSTANCE::clientToDto
        ).orElseThrow(
                ()-> new EntityNotFoundException("Aucun client ne correspond a cet Id", ErrorCodes.CLIENT_NOT_FOUND)
        );
    }

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream()
                .map(
                        ClientMapper.INSTANCE::clientToDto
                ).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Null id");
            return ;
        }

        clientRepository.deleteById(id);
    }
}
