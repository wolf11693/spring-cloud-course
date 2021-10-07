package com.xantrix.webapp.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xantrix.webapp.entity.Articolo;
import com.xantrix.webapp.repository.ArticoloRepository;
import com.xantrix.webapp.service.ArticoloService;

@Service
public class ArticoloServiceImpl implements ArticoloService {
	private final Logger LOG = LoggerFactory.getLogger(ArticoloServiceImpl.class);
	
	@Autowired
	private ArticoloRepository articoloRepository;
	
	@Override
	public List<Articolo> getAll(){
		LOG.info("** getAll - START **");
		List<Articolo> articoli = this.articoloRepository.findAll();
		LOG.info("** getAll - END **");

		return articoli;
	}
	
	@Override
	public Articolo getByCodice(String theCodiceArticolo) {
		LOG.info("** getByCodice - START theCodiceArticolo={} **", theCodiceArticolo);
		Articolo articolo = this.articoloRepository.findByCodice(theCodiceArticolo);
		LOG.info("** getByCodice - END **");
		
		return articolo;
	}

	@Override
	public List<Articolo> getByDescrizioneLike(String theDescrizioneFilter) {
		LOG.info("** getByDescrizioneLike - START - theDescrzioneFilter={} **", theDescrizioneFilter);
		List<Articolo> articoli = this.articoloRepository.findByDescrizioneLike(theDescrizioneFilter);
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