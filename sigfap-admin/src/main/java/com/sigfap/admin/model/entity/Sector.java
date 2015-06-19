package com.sigfap.admin.model.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "setor")
public class Sector implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="setor_id")
	private Integer id;
	
	@Column(name = "setor_nome")
	private String nome;
	
	@Column(name = "setor_descricao")
	private String descricao;
	
	public Sector(){
		
	}
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "unidade_id", insertable = true, updatable = true)
	private Unit unidade;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Unit getUnidade() {
		return unidade;
	}

	public void setUnidade(Unit unidade) {
		this.unidade = unidade;
	}

}
