package com.sigfap.admin.model.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="telefone")
public class Telephone implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="telefone_id")
	private Integer id;
	
	@Column(name="telefone_numero")
	private String numero;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pesquisador_id", insertable = true, updatable = true, foreignKey = @ForeignKey(name="telefone_pesquisador_id_fkey"))
	private Research pesquisador;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "unidade_id")
	private Unit unidadeT;
	
	@OneToOne
	@JoinColumn(name = "representante_id")
	private Representative representante;
	
	public Telephone() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public Research getPesquisador() {
		return pesquisador;
	}
	
	public void setPesquisador(Research pesquisador) {
		this.pesquisador = pesquisador;
	}
	
	public Unit getUnidadeT() {
		return unidadeT;
	}
	
	public void setUnidadeT(Unit unidadeT) {
		this.unidadeT = unidadeT;
	}
	
	
	
	
	public Representative getRepresentante() {
		return representante;
	}

	public void setRepresentante(Representative representante) {
		this.representante = representante;
	}

	@Override
	public String toString() {
		return "Telephone [id=" + id + ", numero=" + numero + "]";
	}
	
}
