package com.xantrix.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xantrix.webapp.entity.Articolo;

@Repository
public interface ArticoloRepository extends JpaRepository<Articolo, String> {

	public Articolo findByCodice(String codice);
	
	public List<Articolo> findByDescrizioneLike(String descrizione);
	
	// Query JPQL
	@Query("SELECT "
		 + "	art"
		 + "FROM "
		 + "	Articolo art"
		 + 	"	JOIN art.barcodes bar"
		 + "WHERE 1=1"
		 + "	AND bar.barcodeString IN ( :bCode )")
	public Articolo findByBarcode(@Param("bCode") String barcode);
}
