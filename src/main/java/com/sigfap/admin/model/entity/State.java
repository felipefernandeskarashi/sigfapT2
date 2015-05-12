package com.sigfap.admin.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "estado")
public class State implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "estado_uf")
	private String uf;
	
	@Column(name = "estado_name")
	private String name;
	
	public State(){
		
	}
	
	@OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
	private List<City> cidades = new ArrayList<City>();

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<City> getCidades(){
		return this.cidades;
	}
	
	public void addCidade(City cidade){
		this.cidades.add(cidade);
		cidade.setEstado(this);
	}
}
