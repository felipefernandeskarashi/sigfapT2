package com.sigfap.admin.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "etnia") 
public class Ethnicity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "etnia_id")
	private Integer id;
	
	@Column(name = "etnia_ativa")
	private Boolean ativa;
	
	@Column(name = "etnia_nome")
	private String nome;
	
	@OneToMany(mappedBy = "etniaPes", cascade = CascadeType.ALL)
	private List<Research> pesquisadores = new ArrayList<Research>();
	
	public Ethnicity() {
		
	}

	public boolean getAtiva() {
		return ativa;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Research> getPesquisadores() {
		return pesquisadores;
	}
	
	public void setPesquisadores(List<Research> pesquisadores) {
		this.pesquisadores = pesquisadores;
	}
}
