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
	
	public List<Articolo> findByDescrizioneLike(String descrizioneFilter);
	
	// Query JPQL
	@Query("SELECT art FROM Articolo art JOIN art.barcodes bar WHERE bar.barcodeString IN (:bCode)")
//	@Query(value="SELECT * FROM Articoli a INNER JOIN Barcode b ON a.codArt=b.codArt WHERE b.barcode=:bCode", nativeQuery = true)
	public Articolo findByBarcode(@Param("bCode") String barcode);
}
