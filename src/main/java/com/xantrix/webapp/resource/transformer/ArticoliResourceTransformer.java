package com.xantrix.webapp.resource.transformer;

import java.util.List;

import org.springframework.stereotype.Component;

import com.xantrix.webapp.entity.Articolo;
import com.xantrix.webapp.resource.ArticoliResource;

@Component
public class ArticoliResourceTransformer implements ResourceTransfromer<ArticoliResource, List<Articolo>> {

	@Override
	public ArticoliResource transformFrom(List<Articolo> artListModel) {
		return this.mapObjModelToResource(artListModel);
	}

	private ArticoliResource mapObjModelToResource(List<Articolo> artListModel) {
		ArticoliResource articoliResource = new ArticoliResource(artListModel);
		return articoliResource;
	}

}
