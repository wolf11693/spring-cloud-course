package com.xantrix.webapp.UnitTest.RepositoryTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.xantrix.webapp.Application;
import com.xantrix.webapp.entity.Articolo;
import com.xantrix.webapp.entity.Barcode;
import com.xantrix.webapp.entity.FamigliaAssortimento;
import com.xantrix.webapp.repository.ArticoloRepository;

@SpringBootTest
@ContextConfiguration(classes = Application.class)
@TestMethodOrder(OrderAnnotation.class)
public class ArticoloRepositoryTest {
	@Autowired
	private ArticoloRepository articoloRepository;

	@Test
	@Order(1)
	public void testInserimentoArticolo() {
		Articolo articolo = this.createArticoloMock();
		this.articoloRepository.save(articolo);

		assertThat(this.articoloRepository.findByCodice("123Test"))
			.extracting(Articolo::getDescrizione)
			.isEqualTo("Articolo di Test");
	}

	private Articolo createArticoloMock() {
		Articolo articolo = new Articolo();
		articolo.setCodice("123Test");
		articolo.setDescrizione("Articolo di Test");
		articolo.setFamigliaAssortimento(this.createFamigliaAssortimento());
		articolo.setBarcodes(this.createBarcodesByArticolo(articolo));
		
		return articolo;
		
	}
	
	private FamigliaAssortimento createFamigliaAssortimento() {
		FamigliaAssortimento famigliaAssortimento = new FamigliaAssortimento();
		famigliaAssortimento.setCodice(1);

		return famigliaAssortimento;
	}
	
	private Set<Barcode> createBarcodesByArticolo(final Articolo articolo) {
		Set<Barcode> barcodes = new HashSet<>();
		Barcode barcode = new Barcode();
		barcode.setBarcodeString("121312");
		barcode.setIdTipoArticolo("CP");
		barcode.setArticolo(articolo);
		barcodes.add(barcode);
		
		return barcodes;

	}
	
	@Test
	@Order(2)
	public void testGetArticoliByDescrizioneLike() {
		List<Articolo> articoli = this.articoloRepository.findByDescrizioneLike("Articolo di Test");
		assertEquals(1, articoli.size());
	}

	@Test
	@Order(3)
	public void testGetArticoloByBarcode() throws Exception {
		assertThat(this.articoloRepository.findByBarcode("121312"))
				.extracting(Articolo::getDescrizione)
				.isEqualTo("Articolo di Test");
	}

	@Test
	@Order(4)
	public void testDeleteArticolo() {
		Articolo articolo = this.articoloRepository.findByCodice("123Test");
		this.articoloRepository.delete(articolo);
		assertNull(this.articoloRepository.findByCodice("123Test"));
	}

}