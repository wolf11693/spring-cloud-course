package com.xantrix.webapp.repository.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xantrix.webapp.entity.Articolo;
import com.xantrix.webapp.repository.ArticoloRepository;
import com.xantrix.webapp.service.ArticoloService;

public class ArticoloServiceImpl implements ArticoloService {
	private final Logger LOG = LoggerFactory.getLogger(ArticoloServiceImpl.class);
	
	private ArticoloRepository articoloRepository;
	
	@Override
	public Articolo getByCodice(String theCodiceArticolo) {
		LOG.info("** getByCodice - START theCodiceArticolo={} **", theCodiceArticolo);
		Articolo articolo = this.articoloRepository.findByCodice(theCodiceArticolo);
		LOG.info("** getByCodice - END **");
		
		return articolo;
	}

	@Override
	public List<Articolo> getByDescrizioneLike(String theDescrzioneFilter) {
		LOG.info("** getByDescrizioneLike - START - theDescrzioneFilter={} **", theDescrzioneFilter);
		List<Articolo> articoli = this.articoloRepository.findByDescrizioneLike(theDescrzioneFilter);
		LOG.info("** getByDescrizioneLike - END **");
	
		return articoli;
	}

	@Override
	public Articolo getByBarcode(String theBarcodeValue) {
		LOG.info("** getByBarcode - START theBarcodeValue={} **", theBarcodeValue);
		Articolo articolo = this.articoloRepository.findByBarcode(theBarcodeValue);
		LOG.info("** getByBarcode - END **");
		
		return articolo;
	}

	@Override
	public Articolo insert(Articolo articoloToIns) {
		LOG.info("** insert - START articolo={} **", articoloToIns);
		Articolo articoloInserted = this.articoloRepository.save(articoloToIns);
		LOG.info("** insert - END **");
		
		return articoloInserted;
	}

}
