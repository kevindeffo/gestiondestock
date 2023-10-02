package com.desktech.gestiondestock.repository;

import com.desktech.gestiondestock.model.Utilisateur;
import com.desktech.gestiondestock.model.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VentesRepository extends JpaRepository<Ventes, Integer> {
    Optional<Ventes> findVentesByCode(String code);
}
