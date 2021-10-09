package com.xantrix.webapp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.xantrix.webapp.entity.Articolo;
import com.xantrix.webapp.repository.ArticoloRepository;
import com.xantrix.webapp.service.ArticoloService;
import com.xantrix.webapp.service.exception.DeleteException;
import com.xantrix.webapp.service.exception.SaveException;
import com.xantrix.webapp.service.exception.UpdateException;

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
	public Articolo getById(String theIdArticolo) {
		LOG.info("** getById - START theCodiceArticolo={} **", theIdArticolo);
		if(theIdArticolo == null || StringUtils.trimAllWhitespace(theIdArticolo).isEmpty()) {
			return null;
		}
		Optional<Articolo> articoloOpt = this.articoloRepository.findById(theIdArticolo);
		LOG.info("** getById - END **");
		
		return articoloOpt.orElse(null);
	}

	@Override
	public List<Articolo> getByDescrizioneLike(String theDescrizioneFilter) {
		LOG.info("** getByDescrizioneLike - START - theDescrzioneFilter={} **", theDescrizioneFilter);
		if(theDescrizioneFilter == null || StringUtils.trimAllWhitespace(theDescrizioneFilter).isEmpty()) {
			return new ArrayList<Articolo>();
		}
		List<Articolo> articoli = this.articoloRepository.findByDescrizioneLike("%" + theDescrizioneFilter.toUpperCase() + "%");
		LOG.info("** getByDescrizioneLike - END **");
	
		return articoli;
	}

	@Override
	public Articolo getByBarcode(String theBarcodeValue) {
		LOG.info("** getByBarcode - START theBarcodeValue={} **", theBarcodeValue);
		if(theBarcodeValue == null || StringUtils.trimAllWhitespace(theBarcodeValue).isEmpty()) {
			return null;
		}
		Articolo articolo = this.articoloRepository.findByBarcode(theBarcodeValue);
		LOG.info("** getByBarcode - END **");
		
		return articolo;
	}

	@Override
	public Articolo save(Articolo articoloToIns) throws SaveException {
		LOG.info("** insert - START articolo={} **", articoloToIns);
		if(articoloToIns == null) {
			throw new SaveException("");
		}
		Articolo articoloInserted = this.articoloRepository.save(articoloToIns);
		LOG.info("** insert - END **");
		
		return articoloInserted;
	}

	@Override
	public void update(String idObjToUpd, Articolo dataObjToUpd) throws UpdateException {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(String idObjToDel) throws DeleteException {
		// TODO Auto-generated method stub
	}
}