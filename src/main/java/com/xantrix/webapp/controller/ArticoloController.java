package com.xantrix.webapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xantrix.webapp.entity.Articolo;
import com.xantrix.webapp.resource.ArticoliResource;
import com.xantrix.webapp.resource.ArticoloResource;
import com.xantrix.webapp.resource.transformer.ArticoliResourceTransformer;
import com.xantrix.webapp.resource.transformer.ArticoloResourceTransformer;
import com.xantrix.webapp.response.ResponseBody;
import com.xantrix.webapp.service.ArticoloService;

@RestController
@RequestMapping(path = "/api/articolo")
public class ArticoloController {
	private static final Logger LOG = LoggerFactory.getLogger(ArticoloController.class);
	
	@Autowired
	private ArticoloService articoloService;
	@Autowired
	private ArticoloResourceTransformer artResTransf;
	@Autowired
	private ArticoliResourceTransformer artsResTransf;
	
	
	@GetMapping(path = "/all")
	public ResponseEntity<ResponseBody<ArticoliResource>> getArticoli() {
		LOG.info("** GET api/articolo/all - getArticoli - barcode={} - START **");
		
		List<Articolo> articoliFetched = this.articoloService.getAll();
		ArticoliResource articoliResource = this.artsResTransf.getResourceByModel(articoliFetched);
		ResponseBody<ArticoliResource> responseBody = new ResponseBody<>(articoliResource);
		
		LOG.info("** GET api/articolo/all - getArticoli - END **");
		return new ResponseEntity<ResponseBody<ArticoliResource>>(responseBody, HttpStatus.OK);
	}
	
	@GetMapping(path = "/{codArt}")
	public ResponseEntity<ResponseBody<ArticoloResource>> getArticoloByCodice(
			@PathVariable(value = "codArt") String codiceArticolo) {
		LOG.info("** GET api/articolo/{} - getArticoloByCodice - codiceArticolo={} - START **", codiceArticolo, codiceArticolo);
		
		Articolo articoloFetched = this.articoloService.getByCodice(codiceArticolo);
		ArticoloResource articoloResource = artResTransf.getResourceByModel(articoloFetched);
		ResponseBody<ArticoloResource> responseBody = new ResponseBody<>(articoloResource);
		
		LOG.info("** GET api/articolo/{} - getArticoloByCodice - END **", codiceArticolo);
		return new ResponseEntity<ResponseBody<ArticoloResource>>(responseBody, HttpStatus.OK);
	}
	
	@GetMapping(path = "/barcode/{barcodeValue}")
	public ResponseEntity<ResponseBody<ArticoloResource>> getArticoloByBarcode(
			@PathVariable(value = "barcode") String barcodeValue) {
		LOG.info("** GET api/articolo/barcode/{} - getArticoloByBarcode - barcode={} - START **", barcodeValue, barcodeValue);
		
		Articolo articoloFetched = this.articoloService.getByBarcode(barcodeValue);
		ArticoloResource articoloResource = artResTransf.getResourceByModel(articoloFetched);
		ResponseBody<ArticoloResource> responseBody = new ResponseBody<>(articoloResource);
		
		LOG.info("** GET api/articolo/barcode/{} - getArticoloByCodice - END **", barcodeValue);
		return new ResponseEntity<ResponseBody<ArticoloResource>>(responseBody, HttpStatus.OK);
	}
	
}