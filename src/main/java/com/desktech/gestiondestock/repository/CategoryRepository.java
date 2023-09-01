package com.desktech.gestiondestock.repository;

import com.desktech.gestiondestock.model.Category;
import com.desktech.gestiondestock.model.MouvementStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
