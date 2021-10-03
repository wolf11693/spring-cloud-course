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

@JsonRootName(value = "articolo")
public class ArticoloResource implements Serializable, Resource {
	private static final long serialVersionUID = -5794820242221303814L;

	@JsonProperty(value = "codiceArticolo")
	private String codice;

	@JsonProperty(value = "descrizioneArticolo")
	private String descrizione;

	@JsonProperty(value = "um")
	private String um;

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

	public ArticoloResource setCodice(String codice) {
		this.codice = codice;
		return this;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public ArticoloResource setDescrizione(String descrizione) {
		this.descrizione = descrizione;
		return this;
	}

	public String getUm() {
		return um;
	}

	public ArticoloResource setUm(String um) {
		this.um = um;
		return this;
	}

	public String getCodiceStatistico() {
		return codiceStatistico;
	}

	public ArticoloResource setCodiceStatistico(String codiceStatistico) {
		this.codiceStatistico = codiceStatistico;
		return this;
	}

	public Integer getPzCart() {
		return pzCart;
	}

	public ArticoloResource setPzCart(Integer pzCart) {
		this.pzCart = pzCart;
		return this;
	}

	public Double getPesoNetto() {
		return pesoNetto;
	}

	public ArticoloResource setPesoNetto(Double pesoNetto) {
		this.pesoNetto = pesoNetto;
		return this;
	}

	public String getIdStatoArticolo() {
		return idStatoArticolo;
	}

	public ArticoloResource setIdStatoArticolo(String idStatoArticolo) {
		this.idStatoArticolo = idStatoArticolo;
		return this;
	}

	public Date getDataCreazione() {
		return dataCreazione;
	}

	public ArticoloResource setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
		return this;
	}

	public Iva getIva() {
		return iva;
	}

	public ArticoloResource setIva(Iva iva) {
		this.iva = iva;
		return this;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public ArticoloResource setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
		return this;
	}

	public Set<Barcode> getBarcodes() {
		return barcodes;
	}

	public ArticoloResource setBarcodes(Set<Barcode> barcodes) {
		this.barcodes = barcodes;
		return this;
	}

	public FamigliaAssortimento getFamigliaAssortimento() {
		return famigliaAssortimento;
	}

	public ArticoloResource setFamigliaAssortimento(FamigliaAssortimento famigliaAssortimento) {
		this.famigliaAssortimento = famigliaAssortimento;
		return this;
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
