package com.desktech.gestiondestock.repository;

import com.desktech.gestiondestock.model.Utilisateur;
import com.desktech.gestiondestock.model.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentesRepository extends JpaRepository<Ventes, Integer> {
}
