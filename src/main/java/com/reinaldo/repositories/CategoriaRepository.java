package com.reinaldo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reinaldo.domain.Categoria;
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
