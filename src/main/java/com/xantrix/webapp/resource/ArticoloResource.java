package com.xantrix.webapp.resource;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.xantrix.webapp.entity.Barcode;
import com.xantrix.webapp.entity.FamigliaAssortimento;
import com.xantrix.webapp.entity.Ingrediente;
import com.xantrix.webapp.entity.Iva;

@JsonRootName(value = "Articolo")
public class ArticoloResource implements Serializable, Resource {
	private static final long serialVersionUID = -5794820242221303814L;

	@JsonProperty(value = "codiceArticolo")
	private String codice;

	@JsonProperty(value = "descrizioneArticolo")
	private String descrizione;

	@JsonProperty(value = "um")
	private Integer um;

	@JsonProperty(value = "codiceStatisticoArticolo")
	private String codiceStatistico;

	@JsonProperty(value = "pzCart")
	private Integer pzCart;

	@JsonProperty(value = "pesoNettoArticolo")
	private Double pesoNetto;

	@JsonProperty(value = "idStatoArticolo")
	private String idStatoArticolo;

	@JsonProperty(value = "dataCreazioneArticolo")
	private Date dataCreazione;

	@JsonProperty(value = "ivaArticolo")
	private Iva iva;

	@JsonProperty(value = "ingredienteArticolo")
	private Ingrediente ingrediente;

	@JsonProperty(value = "codiciABarreArticolo")
	private Set<Barcode> barcodes = new HashSet<>();

	@JsonProperty(value = "famigliaAssortimento")
	private FamigliaAssortimento famigliaAssortimento;

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Integer getUm() {
		return um;
	}

	public void setUm(Integer um) {
		this.um = um;
	}

	public String getCodiceStatistico() {
		return codiceStatistico;
	}

	public void setCodiceStatistico(String codiceStatistico) {
		this.codiceStatistico = codiceStatistico;
	}

	public Integer getPzCart() {
		return pzCart;
	}

	public void setPzCart(Integer pzCart) {
		this.pzCart = pzCart;
	}

	public Double getPesoNetto() {
		return pesoNetto;
	}

	public void setPesoNetto(Double pesoNetto) {
		this.pesoNetto = pesoNetto;
	}

	public String getIdStatoArticolo() {
		return idStatoArticolo;
	}

	public void setIdStatoArticolo(String idStatoArticolo) {
		this.idStatoArticolo = idStatoArticolo;
	}

	public Date getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public Iva getIva() {
		return iva;
	}

	public void setIva(Iva iva) {
		this.iva = iva;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	public Set<Barcode> getBarcodes() {
		return barcodes;
	}

	public void setBarcodes(Set<Barcode> barcodes) {
		this.barcodes = barcodes;
	}

	public FamigliaAssortimento getFamigliaAssortimento() {
		return famigliaAssortimento;
	}

	public void setFamigliaAssortimento(FamigliaAssortimento famigliaAssortimento) {
		this.famigliaAssortimento = famigliaAssortimento;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ArticoloResource [codice=");
		builder.append(codice);
		builder.append(", descrizione=");
		builder.append(descrizione);
		builder.append(", um=");
		builder.append(um);
		builder.append(", codiceStatistico=");
		builder.append(codiceStatistico);
		builder.append(", pzCart=");
		builder.append(pzCart);
		builder.append(", pesoNetto=");
		builder.append(pesoNetto);
		builder.append(", idStatoArticolo=");
		builder.append(idStatoArticolo);
		builder.append(", dataCreazione=");
		builder.append(dataCreazione);
		builder.append(", iva=");
		builder.append(iva);
		builder.append(", ingrediente=");
		builder.append(ingrediente);
		builder.append(", barcodes=");
		builder.append(barcodes);
		builder.append(", famigliaAssortimento=");
		builder.append(famigliaAssortimento);
		builder.append("]");
		return builder.toString();
	}

}
