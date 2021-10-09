package com.xantrix.webapp.service;

import java.util.List;

import com.xantrix.webapp.entity.Articolo;

public interface ArticoloService extends GenericService<Articolo, String>{
	
	public List<Articolo> getByDescrizioneLike(String theDescrzioneFilter);
	
	public Articolo getByBarcode(String theBarcodeValue);
}
