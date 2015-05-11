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
@Table(name = "pais")
public class Country implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pais_id")
	private Integer id;
	
	@Column(name = "pais_nome")
	private String nome;
	
	@Column(name = "pais_sigla")
	private String sigla;
	
	public Country(){
		
	}
	
	@OneToMany(mappedBy = "pais", cascade = CascadeType.ALL)
	private List<Address> enderecos = new ArrayList<Address>();

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
	
	public List<Address> getEnderecos(){
		return this.enderecos;
	}
	
	public void addEndereco(Address endereco){
		this.enderecos.add(endereco);
		endereco.setPais(this);
	}
	
}
