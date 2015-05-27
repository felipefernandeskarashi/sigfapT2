package com.sigfap.admin.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "unidade")
public class Unit implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="unidade_id")
	private Integer id;
	
	@Column(name = "unidade_nome")
	private String nome;
	
	@Column(name = "unidade_email")
	private String email;
	
	@Column(name = "unidade_publicar")
	private String publicar;
	
	@Column(name = "unidade_ativa")
	private Boolean ativa;
	
	@Column(name = "unidade_principal")
	private Boolean principal;
	
	@Column(name = "unidade_fape_uso")
	private Integer fapeUso;
	
	@Column(name = "unidade_cnpj")
	private String cnpj;
	
	@Column(name = "unidadecol")
	private String col;
	
	public Unit(){
		
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "instituicao_id", insertable = true, updatable = true)
	private Institution instituicao;
	
	@OneToMany(mappedBy = "unidade", cascade = CascadeType.ALL)
	private List<Sector> setores = new ArrayList<Sector>();
	
	@OneToOne
	@JoinColumn(name = "endereco_id")
	private Address enderecoUn;
	
	@OneToMany(mappedBy = "unidadeT", cascade = CascadeType.ALL)
	private List<Telephone> telefones = new ArrayList<Telephone>();
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "pesquisadorUnidades")
	private List<Research> pesquisadores = new ArrayList<Research>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "representante_unidade", joinColumns = { @JoinColumn(name = "representante_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "unidade_id", nullable = false, updatable = false) })
	private List<Representative> representanteUnidades = new ArrayList<Representative>();
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPublicar() {
		return publicar;
	}

	public void setPublicar(String publicar) {
		this.publicar = publicar;
	}

	public boolean getAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

	public boolean isPrincipal() {
		return principal;
	}

	public void setPrincipal(boolean principal) {
		this.principal = principal;
	}

	public Integer getFapeUso() {
		return fapeUso;
	}

	public void setFapeUso(Integer fapeUso) {
		this.fapeUso = fapeUso;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCol() {
		return col;
	}

	public void setCol(String col) {
		this.col = col;
	}
	
	public Institution getInstituicao(){
		return this.instituicao;
	}
	
	public void setInstituicao(Institution instituicao){
		this.instituicao = instituicao;
	}
	
	public List<Sector> getSetores(){
		return this.setores;
	}
	
	public void addSetor(Sector setor){
		this.setores.add(setor);
		setor.setUnidade(this);
	}
	
	public Address getEndereco(){
		return this.enderecoUn;
	}
	
	public void setEndereco(Address endereco){
		this.enderecoUn = endereco;
	}

	public List<Telephone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telephone> telefones) {
		this.telefones = telefones;
	}

	public List<Research> getPesquisadores() {
		return pesquisadores;
	}

	public void setPesquisadores(List<Research> pesquisadores) {
		this.pesquisadores = pesquisadores;
	}

	public List<Representative> getRepresentanteUnidades() {
		return representanteUnidades;
	}

	public void setRepresentanteUnidades(Representative representanteUnidades) {
		this.representanteUnidades.add(representanteUnidades);
	}

	public void setSetores(List<Sector> setores) {
		this.setores = setores;
	}
	
	public String getAtivaText(){
		if(this.getAtiva()) return "Ativa";
		
		return "Inativa";
	}
	
	
}