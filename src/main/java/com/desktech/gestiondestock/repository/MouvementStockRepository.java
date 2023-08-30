package com.desktech.gestiondestock.repository;

import com.desktech.gestiondestock.model.MouvementStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MouvementStockRepository extends JpaRepository<Integer, MouvementStock> {
}
