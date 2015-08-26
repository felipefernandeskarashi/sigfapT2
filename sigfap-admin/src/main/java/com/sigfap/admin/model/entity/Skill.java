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
@Table(name="area_conhecimento")
public class Skill implements Serializable{
	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="area_conhecimento_id")
	private Integer id;
	
	@Column(name="area_conhecimento_verificador")
	private String verificador;
	
	@Column(name="area_conhecimento_nome")
	private String nome;
	
	@Column(name="area_conhecimento_ativa")
	private boolean ativa;
	
	@Column(name="area_conhecimento_nivel1")
	private Integer nivel1;
	
	@Column(name="area_conhecimento_nivel2")
	private Integer nivel2;
	
	@Column(name="area_conhecimento_nivel3")
	private Integer nivel3;
	
	@Column(name="area_conhecimento_nivel4")
	private Integer nivel4;
	
	
	@OneToMany(mappedBy = "area", cascade = CascadeType.ALL)
	private List<Research> pesquisadores = new ArrayList<Research>();
	
	public Integer getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getVerificador() {
		return verificador;
	}
	
	public boolean isAtiva() {
		return ativa;
	}
	
	public Integer getNivel1() {
		return nivel1;
	}
	
	public Integer getNivel2() {
		return nivel2;
	}
	
	public Integer getNivel3() {
		return nivel3;
	}
	
	public Integer getNivel4() {
		return nivel4;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setNivel1(Integer nivel1) {
		this.nivel1 = nivel1;
	}
	
	public void setNivel2(Integer nivel2) {
		this.nivel2 = nivel2;
	}
	
	public void setNivel3(Integer nivel3) {
		this.nivel3 = nivel3;
	}
	
	public void setNivel4(Integer nivel4) {
		this.nivel4 = nivel4;
	}
	
	public void setVerificador(String verificador) {
		this.verificador = verificador;
	}	
	
	public List<Research> getPesquisadores() {
		return pesquisadores;
	}
	
	public void setPesquisadores(List<Research> pesquisadores) {
		this.pesquisadores = pesquisadores;
	}
	
	
}
