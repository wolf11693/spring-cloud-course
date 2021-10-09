package com.xantrix.webapp.resource.transformer;

import org.springframework.stereotype.Component;

import com.xantrix.webapp.entity.Articolo;
import com.xantrix.webapp.resource.ArticoloResource;

@Component
public class ArticoloResourceTransformer implements ResourceTransfromer<ArticoloResource, Articolo> {

	@Override
	public ArticoloResource transformFrom(Articolo artModel) {
		if(artModel == null) {
			return null;
		}
		return this.mapObjModelToResource(artModel);
	}

	private ArticoloResource mapObjModelToResource(Articolo artModel) {
		ArticoloResource artResource = new ArticoloResource();

		artResource
			.setId(artModel.getId())
			.setDescrizione(artModel.getDescrizione())
			.setUm(artModel.getUm())
			.setCodiceStatistico(artModel.getCodiceStatistico())
			.setPzCart(artModel.getPzCart())
			.setPesoNetto(artModel.getPesoNetto())
			.setIdStatoArticolo(artModel.getIdStatoArticolo())
			.setDataCreazione(artModel.getDataCreazione())
			.setIva(artModel.getIva())
			.setIngrediente(artModel.getIngrediente())
			.setBarcodes(artModel.getBarcodes())
			.setFamigliaAssortimento(artModel.getFamigliaAssortimento());

		return artResource;
	}

}
