package com.xantrix.webapp.resource.transformer;

import org.springframework.stereotype.Component;

import com.xantrix.webapp.entity.Articolo;
import com.xantrix.webapp.resource.ArticoloResource;

@Component
public class ArticoloResourceTransformer implements ResourceTransfromer<ArticoloResource, Articolo> {

	@Override
	public ArticoloResource transformFrom(Articolo artModel) {
		return this.mapObjModelToResource(artModel);
	}

	private ArticoloResource mapObjModelToResource(Articolo artModel) {
		ArticoloResource artResource = new ArticoloResource();

		artResource.setCodice(artModel.getCodice());
		artResource.setDescrizione(artModel.getDescrizione());
		artResource.setUm(artModel.getUm());
		artResource.setCodiceStatistico(artModel.getCodiceStatistico());
		artResource.setPzCart(artModel.getPzCart());
		artResource.setPesoNetto(artModel.getPesoNetto());
		artResource.setIdStatoArticolo(artModel.getIdStatoArticolo());
		artResource.setDataCreazione(artModel.getDataCreazione());
		artResource.setIva(artModel.getIva());
		artResource.setIngrediente(artModel.getIngrediente());
		artResource.setBarcodes(artModel.getBarcodes());
		artResource.setFamigliaAssortimento(artModel.getFamigliaAssortimento());

		return artResource;
	}

}
