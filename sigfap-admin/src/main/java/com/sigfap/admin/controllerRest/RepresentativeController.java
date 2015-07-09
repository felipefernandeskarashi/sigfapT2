package com.sigfap.admin.controllerRest;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.exception.JDBCConnectionException;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

import com.sigfap.admin.json.representative.Error;
import com.sigfap.admin.model.dao.AddressDAO;
import com.sigfap.admin.model.dao.RepresentativeDAO;
import com.sigfap.admin.model.entity.Address;
import com.sigfap.admin.model.entity.Representative;
import com.sigfap.admin.security.intercept.annotation.Public;
import com.sigfap.admin.validation.CheckCpf;

@Controller
public class RepresentativeController {

	private final Result result1;
	
	@Inject
	private RepresentativeDAO dao;
	
	@Inject
	private AddressDAO dao2;
	
	@Inject
	private CheckCpf cpfValidation;
	
	
	/**
	 * @deprecated CDI eyes only
	 */
	protected RepresentativeController(){
		this(null);
	}
	
	@Inject
	public RepresentativeController(Result result){
		this.result1 = result;
	}
	
	@Public
	@Get("/v1/representatives")
	public void listar(){
		try{
			List<Representative> rep = dao.findAll();
			com.sigfap.admin.json.representative.Result result = 
					new com.sigfap.admin.json.representative.Result();
			result.setRepresentantes(rep);
			result1.use(Results.json()).from(result).include("representantes").serialize();
		}catch(JDBCConnectionException e){
			com.sigfap.admin.json.representative.Error erro =
					new com.sigfap.admin.json.representative.Error(
							"Erro de comunicação com o banco, tente mais tarde");
		}catch (Exception e) {
			com.sigfap.admin.json.representative.Error erro =
					new com.sigfap.admin.json.representative.Error(
							"Não foi possível listar os representantes");
		}
	}
	
	@Public
	@Delete("/v1/representative/{id}")
	public void deletar(int id){
		try{
			Representative rep = dao.findById(id);
			dao.deleteById(id);
			com.sigfap.admin.json.representative.Result result =
					new com.sigfap.admin.json.representative.Result();
			result.getRepresentantes().add(rep);
			result1.use(Results.json()).from(result).include("representantes").serialize();
			
		}catch(JDBCConnectionException e){
			com.sigfap.admin.json.representative.Error erro =
					new com.sigfap.admin.json.representative.Error(
							"Erro de comunicação com o banco, tente mais tarde");
			result1.use(Results.json()).from(erro).recursive().serialize();
		}catch (Exception e) {
			com.sigfap.admin.json.representative.Error erro =
					new com.sigfap.admin.json.representative.Error(
							"Não foi possível encontrar o representante");
			result1.use(Results.json()).from(erro).recursive().serialize();

		}
	}
	
	@Public
	@Post("/v1/representative")
	public void registrar(Representative representative, Address address){
		String teste = representative.getNome();
		if(teste == null){
			com.sigfap.admin.json.representative.Error error =
					new com.sigfap.admin.json.representative.Error("Informe um nome");
			result1.use(Results.json()).from(error).recursive().serialize();
			return;
		}
		teste = null;
		teste = representative.getCpf();
		if(teste == null){
			com.sigfap.admin.json.representative.Error error =
					new com.sigfap.admin.json.representative.Error("Informe um CPF");
			result1.use(Results.json()).from(error).recursive().serialize();
			return;
		}
		
		if(!cpfValidation.isCpf(representative.getCpf())){
			com.sigfap.admin.json.representative.Error error =
					new com.sigfap.admin.json.representative.Error("Informe um CPF válido");
			result1.use(Results.json()).from(error).recursive().serialize();
			return;
		}
		try{
			dao2.persist(address);
			representative.setEnderecoRep(address);
		}catch(Exception e){
			com.sigfap.admin.json.representative.Error error =
					new com.sigfap.admin.json.representative.Error("Não foi possível salvar endereço");
			result1.use(Results.json()).from(error).recursive().serialize();
			return;
		}
		
		try{
			dao.persist(representative);
		}catch(JDBCConnectionException e){
			com.sigfap.admin.json.representative.Error error =
					new com.sigfap.admin.json.representative.Error(
							"Problema de conexão com o banco, tente mais tarde");
			result1.use(Results.json()).from(error).recursive().serialize();
		}catch(Exception e){
			com.sigfap.admin.json.representative.Error error =
					new com.sigfap.admin.json.representative.Error(
							"Não foi possível criar o Representante");
			result1.use(Results.json()).from(error).recursive().serialize();
		}
	}
	
	@Public
	@Put("/v1/representative")
	public void editar(Representative representative){
		String teste = representative.getNome();
		if(teste == null){
			com.sigfap.admin.json.representative.Error error =
					new com.sigfap.admin.json.representative.Error("Informe um nome");
			result1.use(Results.json()).from(error).recursive().serialize();
			return;
		}
		teste = null;
		teste = representative.getCpf();
		if(teste == null){
			com.sigfap.admin.json.representative.Error error =
					new com.sigfap.admin.json.representative.Error("Informe um CPF");
			result1.use(Results.json()).from(error).recursive().serialize();
			return;
		}
		try{
			dao.update(representative);
		}catch(JDBCConnectionException e){
			com.sigfap.admin.json.representative.Error error =
					new com.sigfap.admin.json.representative.Error(
							"Problema de conexão com o banco, tente mais tarde");
			result1.use(Results.json()).from(error).recursive().serialize();
		}
	}
}