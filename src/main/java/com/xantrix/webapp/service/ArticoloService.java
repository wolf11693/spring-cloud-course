package com.xantrix.webapp.service;

import java.util.List;

import com.xantrix.webapp.entity.Articolo;

public interface ArticoloService {
	public Articolo getByCodice(String theCodiceArticolo);
	
	public List<Articolo> getByDescrizioneLike(String theDescrzioneFilter);
	
	public Articolo getByBarcode(String theBarcodeValue);
	
	public Articolo insert(Articolo articolo);
}
