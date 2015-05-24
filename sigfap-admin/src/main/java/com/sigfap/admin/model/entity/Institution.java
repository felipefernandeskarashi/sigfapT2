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
	private Boolean ies;
	
	@Column(name = "instituicao_dependencia_adm")
	private Integer dependenciaAdm;
	
	@Column(name = "instituicao_fins_lucrativos")
	private Boolean finsLucrativos;
	
	@Column(name = "instituicao_ativa")
	private Boolean ativa;
	
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

	public void setIes(Boolean ies) {
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

	public void setFinsLucrativos(Boolean finsLucrativos) {
		this.finsLucrativos = finsLucrativos;
	}

	public boolean getAtiva() {
		return ativa;
	}

	public void setAtiva(Boolean ativa) {
		this.ativa = ativa;
	}
	
	public List<Unit> getUnidades(){
		return this.unidades;
	}
	
	public void addUnidade(Unit unidade){
		this.unidades.add(unidade);
		unidade.setInstituicao(this);
	}
	
	public String getIesText(){
		if(this.getIes()){
			return "Sim";
		}
		return "Não";
	}
	
	public String getFinsLucrativosText(){
		if(this.getFinsLucrativos()){
			return "Sim";
		}
		return "Não";
	}
	
	public String getAtivaText(){
		if(this.getAtiva()){
			return "Sim";
		}
		return "Não";
	}
	
	public String getDependenciaAdmText(){
		switch (this.getDependenciaAdm()) {
		case 1:
			return "Pública Municipal";
		case 2:
			return "Pública Estadual";
		case 3:
			return "Pública Federal";
		case 4:
			return "Privada";
		case 5:
			return "ONG Nacional";
		case 6:
			return "ONG Internacional";
		default:
			return "Sugerida";
		}

	}
	
}
