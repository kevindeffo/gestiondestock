package com.desktech.gestiondestock.dto;

import com.desktech.gestiondestock.model.Utilisateur;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RolesDto {

    private Integer id;

    private String roleName;

    private UtilisateurDto utilisateur;
}
