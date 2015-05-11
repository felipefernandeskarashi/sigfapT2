package com.sigfap.admin.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private String area_nome;
	
	@Column(name="area_conhecimento_ativa")
	private boolean area_ativa;
	
	@Column(name="area_conhecimento_nivel1")
	private Integer nivel1;
	
	@Column(name="area_conhecimento_nivel2")
	private Integer nivel2;
	
	@Column(name="area_conhecimento_nivel3")
	private Integer nivel3;
	
	@Column(name="area_conhecimento_nivel4")
	private Integer nivel4;
	
	public Integer getId() {
		return id;
	}
	
	public String getArea_nome() {
		return area_nome;
	}
	
	public String getVerificador() {
		return verificador;
	}
	
	public boolean isArea_ativa() {
		return area_ativa;
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
	
	public void setArea_ativa(boolean area_ativa) {
		this.area_ativa = area_ativa;
	}
	
	public void setArea_nome(String area_nome) {
		this.area_nome = area_nome;
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
	
	
	
	
	
	
}
