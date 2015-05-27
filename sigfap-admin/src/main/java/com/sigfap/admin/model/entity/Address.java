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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "endereco")
public class Address implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="endereco_id")
	private Integer id;
	
	@Column(name = "endereco_rua")
	private String rua;
	
	@Column(name = "endereco_numero")
	private String numero;
	
	@Column(name = "endereco_complemento")
	private String complemento;
	
	@Column(name = "endereco_bairro")
	private String bairro;
	
	@Column(name = "endereco_cep_zip")
	private String cepZip;
	
	@Column(name = "endereco_cidade_estrangeira")
	private String cidadeEstrangeira;
	
	public Address(){
		
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pais_id")
	private Country pais;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cidade_id")
	private City cidade;
	
	@OneToOne(mappedBy = "enderecoUn")
	private Unit unidade;
	
	@OneToMany(mappedBy = "enderecoRes", cascade = CascadeType.ALL)
	private List<Research> pesquisadoresRes = new ArrayList<Research>();
	
	@OneToMany(mappedBy = "enderecoCom", cascade = CascadeType.ALL)
	private List<Research> pesquisadoresCom = new ArrayList<Research>();
	
	@OneToOne(mappedBy = "enderecoRep")
	private Representative representante;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCepZip() {
		return cepZip;
	}

	public void setCepZip(String cepZip) {
		this.cepZip = cepZip;
	}

	public String getCidadeEstrangeira() {
		return cidadeEstrangeira;
	}

	public void setCidadeEstrangeira(String cidadeEstrangeira) {
		this.cidadeEstrangeira = cidadeEstrangeira;
	}
	
	public Country getPais() {
		return pais;
	}

	public void setPais(Country pais) {
		this.pais = pais;
	}

	public City getCidade(){
		return this.cidade;
	}
	
	public void setCidade(City cidade){
		this.cidade = cidade;
	}
	
	public Unit getUnidade(){
		return this.unidade;
	}
	
	public void setUnidade(Unit unidade){
		this.unidade = unidade;
	}
	
	public List<Research> getPesquisadoresCom() {
		return pesquisadoresCom;
	}
	
	public List<Research> getPesquisadoresRes() {
		return pesquisadoresRes;
	}
	
	

}
