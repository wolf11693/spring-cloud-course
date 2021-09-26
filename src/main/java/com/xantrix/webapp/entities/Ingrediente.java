package com.xantrix.webapp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "INGREDIENTE")
public class Ingrediente implements Serializable {

	private static final long serialVersionUID = 7763298881475779569L;

	@Column(name = "INFO")
	private String info;

	@OneToOne
	@JoinColumn(name = "CODART")
	@JsonIgnore
	// [INGREDIENTE] --(1,1)-------<==>-------(1,1)-- [ARTICOLO]
	private Articolo articolo;

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Articolo getArticolo() {
		return articolo;
	}

	public void setArticolo(Articolo articolo) {
		this.articolo = articolo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ingrediente [info=");
		builder.append(info);
		builder.append(", articolo=");
		builder.append(articolo);
		builder.append("]");
		return builder.toString();
	}

	
}
