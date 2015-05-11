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
	private String rg_emissor;
	
	@Column(name="pesquisador_rg_data_emissor")
	private Date rg_data_emissor;
	
	@Column(name="pesquisador_rg_estado_emissor")
	private String rg_estado_emissor;
	
	@Column(name="pesquisador_nascimento")
	private String nascimento;
	
	@Column(name="pesquisador_sexo")
	private String sexo;
	
	@Column(name="pesquisador_email")
	private String email;
	
	@Column(name="pesquisador_curriculo")
	private String curriculo;
	
	@Column(name="pesquisador_escolaridade")
	private String escolaridade;
	
	@Column(name="pesquisador_vinculo_empregaticio")
	private boolean vinculo_empregaticio;
	
	@Column(name="pesquisador_vinculo_institucional")
	private boolean vinculo_institucional;
	
	@Column(name="pesquisador_departamento")
	private String departamento;
	
	@Column(name="pesquisador_tempo_servico")
	private String tempo_servico;
	
	@Column(name="pesquisador_regime")
	private String regime;
	
	@Column(name="pesquisador_cargo")
	private String cargo;
	
	@Column(name="pesquisador_tempo_cargo")
	private String tempo_cargo;
	
	@Column(name="pesquisador_endereco_pref")
	private boolean endereco_pref;
	
	@Column(name="pesquisador_data_registro")
	private Date data_registro;
	
	@Column(name="pesquisador_data_atualizacao")
	private Date data_atualizacao;
	
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
	private String modalidade_bolsa;
	
	@Column(name="pesquisador_obj_concessao")
	private String obj_concessao;
	
	@Column(name="pesquisador_receber_info")
	private boolean receber_info;
	
	@Column(name="pesquisador_reg_nacional_estrangeiro")
	private String reg_nacional_estrangeiro;
	
	@Column(name="pesquisador_mae")
	private String mae;
	
	@Column(name="pesquisador_pai")
	private String pai;
	
	@Column(name="pesquisador_url_lattes")
	private String url_lattes;
	
	@Column(name="pesquisador_foto_mime")
	private String foto_mime;
	
	@Column(name="pesquisador_foto_extensao")
	private String foto_extensao;
	
	@Column(name="pesquisador_disponibilidade_viajar")
	private boolean dispo_viajar;
	
	@Column(name="pesquisador_ativo")
	private boolean ativo;
	
	public Integer getId() {
		return id;
	}
	
	public String getCargo() {
		return cargo;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getCurriculo() {
		return curriculo;
	}
	
	public String getCurso() {
		return curso;
	}
	
	public Date getData_atualizacao() {
		return data_atualizacao;
	}
	
	public Date getData_registro() {
		return data_registro;
	}
	
	public String getDepartamento() {
		return departamento;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getEscolaridade() {
		return escolaridade;
	}
	
	public String getFoto_extensao() {
		return foto_extensao;
	}
	
	public String getFoto_mime() {
		return foto_mime;
	}
	
	public String getMae() {
		return mae;
	}
	
	public String getModalidade_bolsa() {
		return modalidade_bolsa;
	}
	
	public String getNascimento() {
		return nascimento;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getObj_concessao() {
		return obj_concessao;
	}
	
	public String getPai() {
		return pai;
	}
	
	public String getPassaporte() {
		return passaporte;
	}
	
	public String getReg_nacional_estrangeiro() {
		return reg_nacional_estrangeiro;
	}
	
	public String getRegime() {
		return regime;
	}
	
	public String getRg() {
		return rg;
	}
	
	public Date getRg_data_emissor() {
		return rg_data_emissor;
	}
	
	public String getRg_emissor() {
		return rg_emissor;
	}
	
	public String getRg_estado_emissor() {
		return rg_estado_emissor;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public String getTempo_cargo() {
		return tempo_cargo;
	}
	
	public String getTempo_servico() {
		return tempo_servico;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public String getUrl_lattes() {
		return url_lattes;
	}
	
	public void setVinculo_institucional(boolean vinculo_institucional) {
		this.vinculo_institucional = vinculo_institucional;
	}
	
	public void setVinculo_empregaticio(boolean vinculo_empregaticio) {
		this.vinculo_empregaticio = vinculo_empregaticio;
	}
	
	public void setUrl_lattes(String url_lattes) {
		this.url_lattes = url_lattes;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public void setTempo_servico(String tempo_servico) {
		this.tempo_servico = tempo_servico;
	}
	
	public void setTempo_cargo(String tempo_cargo) {
		this.tempo_cargo = tempo_cargo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public void setRg_estado_emissor(String rg_estado_emissor) {
		this.rg_estado_emissor = rg_estado_emissor;
	}
	
	public void setRg_emissor(String rg_emissor) {
		this.rg_emissor = rg_emissor;
	}
	
	public void setRg_data_emissor(Date rg_data_emissor) {
		this.rg_data_emissor = rg_data_emissor;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public void setRegime(String regime) {
		this.regime = regime;
	}
	
	public void setReg_nacional_estrangeiro(String reg_nacional_estrangeiro) {
		this.reg_nacional_estrangeiro = reg_nacional_estrangeiro;
	}
	
	public void setReceber_info(boolean receber_info) {
		this.receber_info = receber_info;
	}
	
	public void setPassaporte(String passaporte) {
		this.passaporte = passaporte;
	}
	
	public void setPai(String pai) {
		this.pai = pai;
	}
	
	public void setObj_concessao(String obj_concessao) {
		this.obj_concessao = obj_concessao;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	
	public void setModalidade_bolsa(String modalidade_bolsa) {
		this.modalidade_bolsa = modalidade_bolsa;
	}
	
	public void setMae(String mae) {
		this.mae = mae;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setFoto_mime(String foto_mime) {
		this.foto_mime = foto_mime;
	}
	
	public void setFoto_extensao(String foto_extensao) {
		this.foto_extensao = foto_extensao;
	}
	
	public void setEspecial(boolean especial) {
		this.especial = especial;
	}
	
	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}
	
	public void setEndereco_pref(boolean endereco_pref) {
		this.endereco_pref = endereco_pref;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setDispo_viajar(boolean dispo_viajar) {
		this.dispo_viajar = dispo_viajar;
	}
	
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	public void setData_registro(Date data_registro) {
		this.data_registro = data_registro;
	}
	
	public void setData_atualizacao(Date data_atualizacao) {
		this.data_atualizacao = data_atualizacao;
	}
	
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	public void setCurriculo(String curriculo) {
		this.curriculo = curriculo;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}
	
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public boolean isAtivo() {
		return ativo;
	}
	
	public boolean isBloqueado() {
		return bloqueado;
	}
	
	public boolean isDispo_viajar() {
		return dispo_viajar;
	}
	
	public boolean isEndereco_pref() {
		return endereco_pref;
	}
	
	public boolean isEspecial() {
		return especial;
	}
	
	public boolean isReceber_info() {
		return receber_info;
	}
	
	public boolean isVinculo_empregaticio() {
		return vinculo_empregaticio;
	}
	
	public boolean isVinculo_institucional() {
		return vinculo_institucional;
	}
	
	
	
	
	
}




















