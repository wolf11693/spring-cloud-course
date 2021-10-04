package com.xantrix.webapp.resource;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xantrix.webapp.entity.Articolo;

public class ArticoliResource implements Serializable, Resource {
	private static final long serialVersionUID = 3283670999022018367L;

	@JsonProperty(value = "articoli")
	List<Articolo> articoli = new ArrayList<>();

	public ArticoliResource(List<Articolo> articoli) {
		this.articoli = articoli;
	}

	public List<Articolo> getArticoli() {
		return articoli;
	}

	public void setArticoli(List<Articolo> articoli) {
		this.articoli = articoli;
	}

	public void setArticoliResource(List<Articolo> articoliResource) {
		this.articoli = articoliResource;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ArticoliResource [articoli=");
		builder.append(articoli);
		builder.append("]");
		return builder.toString();
	}

}