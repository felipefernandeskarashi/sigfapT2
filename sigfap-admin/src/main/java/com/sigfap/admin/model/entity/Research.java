package com.sigfap.admin.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="pesquisador")
public class Research implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pesquisador_id")
	private Integer id;
	
	@Column(name="pesquisador_nome")
	private String nome;
	
	@Column(name="pesquisador_cpf")
	private String cpf;
	
	@Column(name="pesquisador_rg")
	private String rg;
	
	@Column(name="pesquisador_rg_emissor")
	private String rgEmissor;
	
	@Column(name="pesquisador_rg_data_emissor")
	//@Temporal(value=TemporalType.DATE)
	private String rgDataEmissor;
	
	@Column(name="pesquisador_rg_estado_emissor")
	private String rgEstadoEmissor;
	
	@Column(name="pesquisador_nascimento")
	//@Temporal(value=TemporalType.DATE)
	private String nascimento;
	
	@Column(name="pesquisador_sexo")
	private String sexo;
	
	@Column(name="pesquisador_email")
	private String email;
	
	@Column(name="pesquisador_senha")
	private String senha;
	
	@Column(name="pesquisador_curriculo")
	private String curriculo;
	
	@Column(name="pesquisador_escolaridade")
	private String escolaridade;
	
	@Column(name="pesquisador_vinculo_empregaticio")
	private boolean vinculoEmpregaticio;
	
	@Column(name="pesquisador_vinculo_institucional")
	private boolean vinculoInstitucional;
	
	@Column(name="pesquisador_departamento")
	private String departamento;
	
	@Column(name="pesquisador_tempo_servico")
	private String tempoServico;
	
	@Column(name="pesquisador_regime")
	private String regime;
	
	@Column(name="pesquisador_cargo")
	private String cargo;
	
	@Column(name="pesquisador_tempo_cargo")
	private String tempoCargo;
	
	@Column(name="pesquisador_endereco_pref")
	private Integer enderecoPref;
	
	@Column(name="pesquisador_data_registro")
	@Temporal(value=TemporalType.DATE)
	private Date dataRegistro;
	
	@Column(name="pesquisador_data_atualizacao")
	@Temporal(value=TemporalType.DATE)
	private Date dataAtualizacao;
	
	@Column(name="pesquisador_bloqueado")
	private boolean bloqueado;
	
	@Column(name="pesquisador_especial")
	private boolean especial;

	@Column(name="pesquisador_curso")
	private String curso;
	
	@Column(name="pesquisador_tipo")
	private String tipo;
	
	@Column(name="pesquisador_passaporte")
	private String passaporte;
	
	@Column(name="pesquisador_categoria")
	private String categoria;
	
	@Column(name="pesquisador_modalidade_bolsa")
	private String modalidadeBolsa;
	
	@Column(name="pesquisador_obj_concessao")
	private String objConcessao;
	
	@Column(name="pesquisador_receber_info")
	private boolean receberInfo;
	
	@Column(name="pesquisador_reg_nacional_estrangeiro")
	private String regNacionalEstrangeiro;
	
	@Column(name="pesquisador_mae")
	private String mae;
	
	@Column(name="pesquisador_pai")
	private String pai;
	
	@Column(name="pesquisador_url_lattes")
	private String urlLattes;
	
	@Column(name="pesquisador_foto_mime")
	private String fotoMime;
	
	@Column(name="pesquisador_foto_extensao")
	private String fotoExtensao;
	
	@Column(name="pesquisador_disponibilidade_viajar")
	private boolean dispoViajar;
	
	@Column(name="pesquisador_ativo")
	private boolean ativo;	
	
	@Column(name="area_conhecimento_id2")
	private Integer area2;
	
	@Column(name="area_conhecimento_id3")
	private Integer area3;
	
	@OneToMany(mappedBy = "pesquisador", cascade = CascadeType.ALL)
	private List<Telephone> telefones = new ArrayList<Telephone>();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "pesquisador_unidade", joinColumns =
    { @JoinColumn(name = "pesquisador_id", nullable = false, updatable = false) }, inverseJoinColumns =
    { @JoinColumn(name = "unidade_id", nullable = false, updatable = false) })
    private List<Unit> pesquisadorUnidades = new ArrayList<Unit>();
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "etnia_id", insertable = true, updatable = true, foreignKey = @ForeignKey(name="pesquisador_etnia_id_fkey"))
	private Ethnicity etniaPes;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_residencial_id", insertable = true, updatable = true, foreignKey = @ForeignKey(name="pesquisador_endereco_residencial_id_fkey"))
	private Address enderecoRes;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_comercial_id", insertable = true, updatable = true, foreignKey = @ForeignKey(name="pesquisador_endereco_comercial_id_fkey"))
	private Address enderecoCom;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "area_conhecimento_id1", insertable = true, updatable = true, foreignKey = @ForeignKey(name="area_conhecimento_id1"))
	private Skill area;
	
	public Research(){
		
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

	public String getRgEmissor() {
		return rgEmissor;
	}

	public void setRgEmissor(String rgEmissor) {
		this.rgEmissor = rgEmissor;
	}

	public String getRgDataEmissor() {
		return rgDataEmissor;
	}
	
	public void setRgDataEmissor(String rgDataEmissor) {
		this.rgDataEmissor = rgDataEmissor;
	}

	public String getRgEstadoEmissor() {
		return rgEstadoEmissor;
	}

	public void setRgEstadoEmissor(String rgEstadoEmissor) {
		this.rgEstadoEmissor = rgEstadoEmissor;
	}

	public String getNascimento() {
		return nascimento;
	}
	
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(String curriculo) {
		this.curriculo = curriculo;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public boolean isVinculoEmpregaticio() {
		return vinculoEmpregaticio;
	}

	public void setVinculoEmpregaticio(boolean vinculoEmpregaticio) {
		this.vinculoEmpregaticio = vinculoEmpregaticio;
	}

	public boolean isVinculoInstitucional() {
		return vinculoInstitucional;
	}

	public void setVinculoInstitucional(boolean vinculoInstitucional) {
		this.vinculoInstitucional = vinculoInstitucional;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getTempoServico() {
		return tempoServico;
	}

	public void setTempoServico(String tempoServico) {
		this.tempoServico = tempoServico;
	}

	public String getRegime() {
		return regime;
	}

	public void setRegime(String regime) {
		this.regime = regime;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getTempoCargo() {
		return tempoCargo;
	}

	public void setTempoCargo(String tempoCargo) {
		this.tempoCargo = tempoCargo;
	}

	public Integer getEnderecoPref() {
		return enderecoPref;
	}
	
	public void setEnderecoPref(Integer enderecoPref) {
		this.enderecoPref = enderecoPref;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	public boolean isEspecial() {
		return especial;
	}

	public void setEspecial(boolean especial) {
		this.especial = especial;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPassaporte() {
		return passaporte;
	}

	public void setPassaporte(String passaporte) {
		this.passaporte = passaporte;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getModalidadeBolsa() {
		return modalidadeBolsa;
	}

	public void setModalidadeBolsa(String modalidadeBolsa) {
		this.modalidadeBolsa = modalidadeBolsa;
	}

	public String getObjConcessao() {
		return objConcessao;
	}

	public void setObjConcessao(String objConcessao) {
		this.objConcessao = objConcessao;
	}

	public boolean isReceberInfo() {
		return receberInfo;
	}

	public void setReceberInfo(boolean receberInfo) {
		this.receberInfo = receberInfo;
	}

	public String getRegNacionalEstrangeiro() {
		return regNacionalEstrangeiro;
	}

	public void setRegNacionalEstrangeiro(String regNacionalEstrangeiro) {
		this.regNacionalEstrangeiro = regNacionalEstrangeiro;
	}

	public String getMae() {
		return mae;
	}

	public void setMae(String mae) {
		this.mae = mae;
	}

	public String getPai() {
		return pai;
	}

	public void setPai(String pai) {
		this.pai = pai;
	}

	public String getUrlLattes() {
		return urlLattes;
	}

	public void setUrlLattes(String urlLattes) {
		this.urlLattes = urlLattes;
	}

	public String getFotoMime() {
		return fotoMime;
	}

	public void setFotoMime(String fotoMime) {
		this.fotoMime = fotoMime;
	}

	public String getFotoExtensao() {
		return fotoExtensao;
	}

	public void setFotoExtensao(String fotoExtensao) {
		this.fotoExtensao = fotoExtensao;
	}

	public boolean isDispoViajar() {
		return dispoViajar;
	}

	public void setDispoViajar(boolean dispoViajar) {
		this.dispoViajar = dispoViajar;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Integer getArea2() {
		return area2;
	}

	public void setArea2(Integer area2) {
		this.area2 = area2;
	}

	public Integer getArea3() {
		return area3;
	}

	public void setArea3(Integer area3) {
		this.area3 = area3;
	}

	public List<Telephone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telephone> telefones) {
		this.telefones = telefones;
	}

	public List<Unit> getPesquisadorUnidades() {
		return pesquisadorUnidades;
	}

	public void setPesquisadorUnidades(List<Unit> pesquisadorUnidades) {
		this.pesquisadorUnidades = pesquisadorUnidades;
	}

	public Ethnicity getEtniaPes() {
		return etniaPes;
	}

	public void setEtniaPes(Ethnicity etniaPes) {
		this.etniaPes = etniaPes;
	}

	public Address getEnderecoRes() {
		return enderecoRes;
	}

	public void setEnderecoRes(Address enderecoRes) {
		this.enderecoRes = enderecoRes;
	}

	public Address getEnderecoCom() {
		return enderecoCom;
	}

	public void setEnderecoCom(Address enderecoCom) {
		this.enderecoCom = enderecoCom;
	}

	public Skill getArea() {
		return area;
	}

	public void setArea(Skill area) {
		this.area = area;
	}
	
	
}