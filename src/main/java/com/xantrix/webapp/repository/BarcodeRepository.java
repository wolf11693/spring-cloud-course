package com.xantrix.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xantrix.webapp.entity.Barcode;

@Repository
public interface BarcodeRepository extends JpaRepository<Barcode, Barcode> {

	public Barcode findByBarcodeString(String barcodeString);

	// Query native in sql
	@Query( value = "SELECT "
				  + "	* "
				  + "FROM "
				  + "	Barcode bar"
				  + "	INNER JOIN Articolo art ON art.codArt = bar.codArt"
				  + "WHERE 1=1"
				  + "	AND bar.codArt = :codiceArticolo", 
			nativeQuery = true )
	public List<Barcode> findBarcodeByArticle(@Param("codiceArticolo") String codArticolo);
}
