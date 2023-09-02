package com.desktech.gestiondestock.repository;

import com.desktech.gestiondestock.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
}
