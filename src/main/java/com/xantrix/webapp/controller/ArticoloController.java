package com.xantrix.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xantrix.webapp.entity.Articolo;
import com.xantrix.webapp.resource.ArticoloResource;
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
	
	@GetMapping(path = "/{codArt}")
	public ResponseEntity<ResponseBody<ArticoloResource>> getArticoloByCodice(
			@Param(value = "codArt") String codiceArticolo) {
		LOG.info(" GET api/articolo/{} - getArticoloByCodice - codiceArticolo={} - START", codiceArticolo, codiceArticolo);
		
		Articolo articoloFetched = this.articoloService.getByCodice(codiceArticolo);
		ArticoloResource articoloResource = artResTransf.getResourceByModel(articoloFetched);
		ResponseBody<ArticoloResource> responseBody = new ResponseBody<>(articoloResource);
		
		LOG.info(" GET api/articolo/{} - getArticoloByCodice - END", codiceArticolo);
		return new ResponseEntity<ResponseBody<ArticoloResource>>(responseBody, HttpStatus.OK);
	}
}
