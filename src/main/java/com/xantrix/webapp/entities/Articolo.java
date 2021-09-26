package com.xantrix.webapp.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Articoli")
public class Articolo implements Serializable {

	private static final long serialVersionUID = 7763298881475779569L;

	@Id
	@Column(name = "CODART")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String codice;

	@Column(name = "DESCRIZIONE")
	private String descrizione;

	@Column(name = "UM")
	private Integer um;

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

	public FamigliaAssortimento getFamigliaAssortimento() {
		return famigliaAssortimento;
	}

	public void setFamigliaAssortimento(FamigliaAssortimento famigliaAssortimento) {
		this.famigliaAssortimento = famigliaAssortimento;
	}

	public Set<Barcode> getBarcodes() {
		return barcodes;
	}

	public void setBarcodes(Set<Barcode> barcodes) {
		this.barcodes = barcodes;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	public Iva getIva() {
		return iva;
	}

	public void setIva(Iva iva) {
		this.iva = iva;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Articolo [codice=");
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