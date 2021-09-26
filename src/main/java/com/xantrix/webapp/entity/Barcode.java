package com.xantrix.webapp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "BarCode")
public class Barcode implements Serializable {

	private static final long serialVersionUID = 7763298881475779569L;

	@Id
	@Column(name = "BARCODE")
	private String barcode;

	@Column(name = "IDTIPOART")
	private Integer idTipoArticolo;

	@ManyToOne
	@JoinColumn(name = "CODART")
	@JsonBackReference
	// [BARCODE] --(1,1)-------<==>-------(1,N)-- [ARTICOLO]
	private Articolo articolo;

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Articolo getArticolo() {
		return articolo;
	}

	public void setArticolo(Articolo articolo) {
		this.articolo = articolo;
	}

	public Integer getIdTipoArticolo() {
		return idTipoArticolo;
	}

	public void setIdTipoArticolo(Integer idTipoArticolo) {
		this.idTipoArticolo = idTipoArticolo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Barcode [barcode=");
		builder.append(barcode);
		builder.append(", idTipoArticolo=");
		builder.append(idTipoArticolo);
		builder.append(", articolo=");
		builder.append(articolo);
		builder.append("]");
		return builder.toString();
	}
}
