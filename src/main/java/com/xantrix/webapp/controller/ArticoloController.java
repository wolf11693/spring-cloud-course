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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xantrix.webapp.controller.exception.ResourceNotFoundException;
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
	private ArticoloResourceTransformer articoloResTransf;
	@Autowired
	private ArticoliResourceTransformer articoliResTransf;
	
	
	@GetMapping(path = "/all")
	public ResponseEntity<ResponseBody<ArticoliResource>> getArticoli() throws Exception {
		LOG.info("** GET api/articolo/all - getArticoli - barcode={} - START **");
		
		List<Articolo> articoliFetched = this.articoloService.getAll();
		ArticoliResource articoliResource = this.articoliResTransf.getResourceByModel(articoliFetched);
		ResponseBody<ArticoliResource> responseBody = new ResponseBody<>(articoliResource);
		
		LOG.info("** GET api/articolo/all - getArticoli - END **");
		return new ResponseEntity<ResponseBody<ArticoliResource>>(responseBody, HttpStatus.OK);
	}
	
	@GetMapping(path = "/{theCodArt}")
	public ResponseEntity<ResponseBody<ArticoloResource>> getArticoloById(
			@PathVariable(value = "theCodArt") String idArticolo) throws Exception {
		LOG.info("** GET api/articolo/{} - getArticoloById - codiceArticolo={} - START **", idArticolo, idArticolo);
		
		Articolo articoloFetched = this.articoloService.getById(idArticolo);
		if(articoloFetched == null) {
			throw new ResourceNotFoundException("La risorsa '" + idArticolo +"' non e' stata trovata");
		}
		ArticoloResource articoloResource = articoloResTransf.getResourceByModel(articoloFetched);
		ResponseBody<ArticoloResource> responseBody = new ResponseBody<>(articoloResource);
		
		LOG.info("** GET api/articolo/{} - getArticoloById - END **", idArticolo);
		return new ResponseEntity<ResponseBody<ArticoloResource>>(responseBody, HttpStatus.OK);
	}
	
	@GetMapping(params = "descrizione")
	public ResponseEntity<ResponseBody<ArticoliResource>> getArticoliByDescrizioneLike(
			@RequestParam(value = "descrizione", required = true) String theDescrizioneLike) throws Exception {
		LOG.info("** GET api/articolo?descrizioneLike={} - getArticoliByDescrizioneLike - descrizioneLike={} - START **", theDescrizioneLike, theDescrizioneLike);
		
		List<Articolo> articoliFetched = this.articoloService.getByDescrizioneLike(theDescrizioneLike);
		if(articoliFetched == null || articoliFetched.isEmpty()) {
			throw new ResourceNotFoundException("La risorsa '" + theDescrizioneLike +"' non e' stata trovata");
		}
		ArticoliResource articoloResource = articoliResTransf.getResourceByModel(articoliFetched);
		ResponseBody<ArticoliResource> responseBody = new ResponseBody<>(articoloResource);
		
		LOG.info("** GET api/articolo?descrizioneLike={} - getArticoliByDescrizioneLike - END **", theDescrizioneLike);
		return new ResponseEntity<ResponseBody<ArticoliResource>>(responseBody, HttpStatus.OK);
	}
	
	@GetMapping(path = "/barcode/{theBarcode}")
	public ResponseEntity<ResponseBody<ArticoloResource>> getArticoloByBarcode(
			@PathVariable(value = "theBarcode") String barcodeValue) throws Exception {
		LOG.info("** GET api/articolo/barcode/{} - getArticoloByBarcode - barcode={} - START **", barcodeValue, barcodeValue);
		
		Articolo articoloFetched = this.articoloService.getByBarcode(barcodeValue);
		if(articoloFetched == null) {
			throw new ResourceNotFoundException("La risorsa '" + barcodeValue +"' non e' stata trovata");
		}
		ArticoloResource articoloResource = articoloResTransf.getResourceByModel(articoloFetched);
		ResponseBody<ArticoloResource> responseBody = new ResponseBody<>(articoloResource);
		
		LOG.info("** GET api/articolo/barcode/{} - getArticoloByCodice - END **", barcodeValue);
		return new ResponseEntity<ResponseBody<ArticoloResource>>(responseBody, HttpStatus.OK);
	}
	
}