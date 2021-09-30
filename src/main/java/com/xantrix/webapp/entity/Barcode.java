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
@Table(name = "BARCODE")
public class Barcode implements Serializable {

	private static final long serialVersionUID = 7763298881475779569L;

	@Id
	@Column(name = "BARCODE")
	private String barcodeString;

	@Column(name = "IDTIPOART")
	private String idTipoArticolo;

	@ManyToOne
	@JoinColumn(name = "CODART")
	@JsonBackReference
	// [BARCODE] --(1,1)-------<==>-------(1,N)-- [ARTICOLO]
	private Articolo articolo;

	public String getBarcodeString() {
		return barcodeString;
	}

	public void setBarcodeString(String barcodeString) {
		this.barcodeString = barcodeString;
	}

	public Articolo getArticolo() {
		return articolo;
	}

	public void setArticolo(Articolo articolo) {
		this.articolo = articolo;
	}

	public String getIdTipoArticolo() {
		return idTipoArticolo;
	}

	public void setIdTipoArticolo(String idTipoArticolo) {
		this.idTipoArticolo = idTipoArticolo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Barcode [barcode=");
		builder.append(barcodeString);
		builder.append(", idTipoArticolo=");
		builder.append(idTipoArticolo);
		builder.append(", articolo=");
		builder.append(articolo);
		builder.append("]");
		return builder.toString();
	}
}
