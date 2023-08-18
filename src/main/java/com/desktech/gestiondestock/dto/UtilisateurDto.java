package com.desktech.gestiondestock.dto;

import com.desktech.gestiondestock.model.Adresse;
import com.desktech.gestiondestock.model.Entreprise;
import com.desktech.gestiondestock.model.Roles;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Builder
@Data
public class UtilisateurDto {

    private Integer id;

    private String nom;

    private String prenom;

    private String email;

    private Instant dateDeNaissance;

    private AdresseDto adresse;

    private String photo;

    private EntrepriseDto entreprise;

    private List<RolesDto> roles;
}
