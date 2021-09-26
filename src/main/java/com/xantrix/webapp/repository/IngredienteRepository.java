package com.xantrix.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xantrix.webapp.entity.Ingrediente;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, String> {

	public Ingrediente findByCodice(String codiceIngrediente);
	
}
