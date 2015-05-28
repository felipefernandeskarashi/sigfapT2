package com.sigfap.admin.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="representante")
public class Representative implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="representante_id")
	private Integer id;
	
	@Column(name="representante_nome")
	private String nome;
	
	@Column(name="representante_cpf")
	private String cpf;
	
	@Column(name="representante_rg")
	private String rg;
	
	@Column(name="representante_rg_emissor")
	private String rgEmissao;
	
	@Column(name="representante_rg_data_emissao")
	private String rgDataEmissao;
	
	@Column(name="representante_cargo")
	private String cargo;
	
	@Column(name="representante_matricula")
	private String matricula;
	
	@Column(name="representante_email")
	private String email;
	
	@Column(name="representante_vigencia_inicio")
	private Date vigenciaInicio;
	
	@Column(name="representante_vigencia_termino")
	private Date vigenciaTermino;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "representanteUnidades")
    private List<Unit> unidades = new ArrayList<Unit>();
	
	@OneToOne
	@JoinColumn(name = "endereco_id")
	private Address enderecoRep;
	
	
	public Representative() {
		
	}

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getRgEmissao() {
		return rgEmissao;
	}

	public void setRgEmissao(String rgEmissao) {
		this.rgEmissao = rgEmissao;
	}

	public String getRgDataEmissao() {
		return rgDataEmissao;
	}

	public void setRgDataEmissao(String rgDataEmissao) {
		this.rgDataEmissao = rgDataEmissao;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getVigenciaInicio() {
		return vigenciaInicio;
	}

	public void setVigenciaInicio(Date vigenciaInicio) {
		this.vigenciaInicio = vigenciaInicio;
	}

	public Date getVigenciaTermino() {
		return vigenciaTermino;
	}

	public void setVigenciaTermino(Date vigenciaTermino) {
		this.vigenciaTermino = vigenciaTermino;
	}

	@Override
	public String toString() {
		return "Representative [id=" + id + ", nome=" + nome + ", cpf=" + cpf
				+ ", rg=" + rg + ", rgEmissao=" + rgEmissao
				+ ", rgDataEmissao=" + rgDataEmissao + ", cargo=" + cargo
				+ ", matricula=" + matricula + ", email=" + email
				+ ", vigenciaInicio=" + vigenciaInicio + ", vigenciaTermino="
				+ vigenciaTermino + "]";
	}

	public List<Unit> getUnidades() {
		return unidades;
	}

	public void setUnidades(Unit unidades) {
		this.unidades.add(unidades);
	}

	public Address getEnderecoRep() {
		return enderecoRep;
	}

	public void setEnderecoRep(Address enderecoRep) {
		this.enderecoRep = enderecoRep;
	}

	public void setUnidades(List<Unit> unidades) {
		this.unidades = unidades;
	}
	
	
}
