package com.xantrix.webapp.entities;

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
@Table(name = "FAMASSORT")
public class FamigliaAssortimento implements Serializable {

	private static final long serialVersionUID = 9099428831950450996L;

	@Id
	@Column(name = "ID")
	private Integer codice;

	@Column(name = "DESCRIZIONE")
	private String descrizione;

	@OneToMany(mappedBy = "famigliaAssortimento", fetch = FetchType.LAZY)
	@JsonBackReference
	// [FAMIGLIA_ASSORTIMENTO] --(1,1)-------<==>-------(1,N)-- [ARTICOLO]
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

	public List<Articolo> getArticoli() {
		return articoli;
	}

	public void setArticoli(List<Articolo> articoli) {
		this.articoli = articoli;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FamigliaAssortimento [codice=");
		builder.append(codice);
		builder.append(", descrizione=");
		builder.append(descrizione);
		builder.append("]");
		return builder.toString();
	}

}
