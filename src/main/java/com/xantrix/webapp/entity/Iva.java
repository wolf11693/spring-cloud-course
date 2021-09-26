package com.xantrix.webapp.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "IVA")
public class Iva implements Serializable {

	private static final long serialVersionUID = 9099428831950450996L;

	@Id
	@Column(name = "IDIVA")
	private Integer codice;

	@Column(name = "DESCRIZIONE")
	private String descrizione;

	@Column(name = "ALIQUOTA")
	private Integer aliquota;

	@OneToMany(mappedBy = "iva", fetch = FetchType.LAZY)
	@JsonBackReference
	private List<Articolo> articoli = new ArrayList<>();

	public Integer getCodice() {
		return codice;
	}

	public void setCodice(Integer codice) {
		this.codice = codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Integer getAliquota() {
		return aliquota;
	}

	public void setAliquota(Integer aliquota) {
		this.aliquota = aliquota;
	}

	public List<Articolo> getArticoli() {
		return articoli;
	}

	public void setArticoli(List<Articolo> articoli) {
		this.articoli = articoli;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Iva [codice=");
		builder.append(codice);
		builder.append(", descrizione=");
		builder.append(descrizione);
		builder.append(", aliquota=");
		builder.append(aliquota);
		builder.append("]");
		return builder.toString();
	}

}