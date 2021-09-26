package com.xantrix.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xantrix.webapp.entity.Articolo;

@Repository
public interface ArticoloRepository extends JpaRepository<Articolo, String> {

	public Articolo findByCodice(String codice);
	
	public List<Articolo> findByDescrizioneLike(String descrizione);
}
