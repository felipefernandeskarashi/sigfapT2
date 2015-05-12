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
@Table(name = "instituicao")
public class Institution implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="instituicao_id")
	private Integer id;
	
	@Column(name = "instituicao_nome")
	private String nome;
	
	@Column(name = "instituicao_sigla")
	private String sigla;
	
	@Column(name = "instituicao_ies")
	private boolean ies;
	
	@Column(name = "instituicao_dependencia_adm")
	private Integer dependenciaAdm;
	
	@Column(name = "instituicao_fins_lucrativos")
	private boolean finsLucrativos;
	
	@Column(name = "instituicao_ativa")
	private boolean ativa;
	
	public Institution(){
		
	}
	
	@OneToMany(mappedBy = "instituicao", cascade = CascadeType.ALL)
	private List<Unit> unidades = new ArrayList<Unit>();
	
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public boolean getIes() {
		return ies;
	}

	public void setIes(boolean ies) {
		this.ies = ies;
	}

	public Integer getDependenciaAdm() {
		return dependenciaAdm;
	}

	public void setDependenciaAdm(Integer dependenciaAdm) {
		this.dependenciaAdm = dependenciaAdm;
	}

	public boolean getFinsLucrativos() {
		return finsLucrativos;
	}

	public void setFinsLucrativos(boolean finsLucrativos) {
		this.finsLucrativos = finsLucrativos;
	}

	public boolean getAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}
	
	public List<Unit> getUnidades(){
		return this.unidades;
	}
	
	public void addUnidade(Unit unidade){
		this.unidades.add(unidade);
		unidade.setInstituicao(this);
	}
	
	
}
