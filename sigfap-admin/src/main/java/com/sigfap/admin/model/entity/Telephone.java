package com.sigfap.admin.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

	@Override
	public String toString() {
		return "Telephone [id=" + id + ", numero=" + numero + "]";
	}
	
}
