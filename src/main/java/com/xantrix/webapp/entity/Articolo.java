package com.xantrix.webapp.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * This class Map Articoli Table
 * */
@Entity
@Table(name = "Articoli")
public class Articolo implements Serializable {
	private static final long serialVersionUID = 7763298881475779569L;

	@Id
	@Column(name = "CODART")
	private String id;

	@Column(name = "DESCRIZIONE")
	private String descrizione;

	@Column(name = "UM")
	private String um;

	@Column(name = "CODSTAT")
	private String codiceStatistico;

	@Column(name = "PZCART")
	private Integer pzCart;

	@Column(name = "PESONETTO")
	private Double pesoNetto;

	@Column(name = "IDSTATOART")
	private String idStatoArticolo;

	@Column(name = "DATACREAZIONE")
	@Temporal(TemporalType.DATE)
	private Date dataCreazione;

	@ManyToOne
	@JoinColumn(name = "IDIVA")
	@JsonManagedReference
	// [ARTICOLO] --(1,N)-------<==>-------(1,1)-- [IVA]
	private Iva iva;

	@OneToOne(mappedBy = "articolo", cascade = CascadeType.ALL, orphanRemoval = true)
	// [ARTICOLO] --(1,1)-------<==>-------(1,1)-- [INGREDIENTE]
	private Ingrediente ingrediente;

	@OneToMany(mappedBy = "articolo", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	// [ARTICOLO] --(1,N)-------<==>-------(1,1)-- [BARCODE]
	private Set<Barcode> barcodes = new HashSet<>();

	@ManyToOne
	@JoinColumn(name = "IDFAMASS")
	@JsonManagedReference
	// [ARTICOLO]--(1,N)-------<==>-------(1,1)-- [FAMIGLIA_ASSORTIMENTO]
	private FamigliaAssortimento famigliaAssortimento;

	public String getId() {
		return id;
	}

	public Articolo setId(String id) {
		this.id = id;
		return this;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public Articolo setDescrizione(String descrizione) {
		this.descrizione = descrizione;
		return this;
	}

	public String getUm() {
		return um;
	}

	public Articolo setUm(String um) {
		this.um = um;
		return this;
	}

	public String getCodiceStatistico() {
		return codiceStatistico;
	}

	public Articolo setCodiceStatistico(String codiceStatistico) {
		this.codiceStatistico = codiceStatistico;
		return this;
	}

	public Integer getPzCart() {
		return pzCart;
	}

	public Articolo setPzCart(Integer pzCart) {
		this.pzCart = pzCart;
		return this;
	}

	public Double getPesoNetto() {
		return pesoNetto;
	}

	public Articolo setPesoNetto(Double pesoNetto) {
		this.pesoNetto = pesoNetto;
		return this;
	}

	public String getIdStatoArticolo() {
		return idStatoArticolo;
	}

	public Articolo setIdStatoArticolo(String idStatoArticolo) {
		this.idStatoArticolo = idStatoArticolo;
		return this;
	}

	public Date getDataCreazione() {
		return dataCreazione;
	}

	public Articolo setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
		return this;
	}

	public FamigliaAssortimento getFamigliaAssortimento() {
		return famigliaAssortimento;
	}

	public Articolo setFamigliaAssortimento(FamigliaAssortimento famigliaAssortimento) {
		this.famigliaAssortimento = famigliaAssortimento;
		return this;
	}

	public Set<Barcode> getBarcodes() {
		return barcodes;
	}

	public Articolo setBarcodes(Set<Barcode> barcodes) {
		this.barcodes = barcodes;
		return this;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public Articolo setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
		return this;
	}

	public Iva getIva() {
		return iva;
	}

	public Articolo setIva(Iva iva) {
		this.iva = iva;
		return this;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Articolo [id=");
		builder.append(id);
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
		builder.append(", iva=");
		builder.append(iva);
		builder.append(", idStatoArticolo=");
		builder.append(idStatoArticolo);
		builder.append(", dataCreazione=");
		builder.append(dataCreazione);
		builder.append(", famigliaAssortimento=");
		builder.append(famigliaAssortimento);
		builder.append("]");
		return builder.toString();
	}

}