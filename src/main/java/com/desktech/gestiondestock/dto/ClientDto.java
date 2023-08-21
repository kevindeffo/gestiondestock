package com.desktech.gestiondestock.dto;

import com.desktech.gestiondestock.model.Adresse;
import com.desktech.gestiondestock.model.Client;
import com.desktech.gestiondestock.model.CommandeClient;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ClientDto {

    private Integer id;

    private String nom;

    private String prenom;

    private  String photo;


    private String email;

    private  String telephone;

    private AdresseDto addresse;

    private List<CommandeClientDto> commandeClients;

    public ClientDto fromEntity(Client client){
        if(client == null){
            return null;
//            TODO: throw an exception
        }

        return ClientDto.builder()
                .id(client.getId())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .photo(client.getPhoto())
                .email(client.getEmail())
                .telephone(client.getTelephone())
                .addresse(new AdresseDto().fromEntity(client.getAddresse()))
                .build();
    }

    public Client toEntity(ClientDto clientDto){
        if(clientDto == null){
            return null;
//            TODO: throw an exception
        }

        Client client = new Client();
        return  client;
    }


}
