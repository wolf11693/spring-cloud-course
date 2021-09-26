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

	@Query( value = "SELECT "
				  + "	art.* "
				  + "FROM Barcode bar "
				  + "INNER JOIN Articolo art ON art.codice = bar.articolo.codice "
				  + "WHERE art.codArt := codiceArticolo" )
	public List<Barcode> findBarCodeByArticle(@Param("codiceArticolo") String codiceArticolo);
}
