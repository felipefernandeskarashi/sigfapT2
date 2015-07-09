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

import com.sigfap.admin.model.dao.AddressDAO;
import com.sigfap.admin.model.dao.InstitutionDAO;
import com.sigfap.admin.model.dao.RepresentativeDAO;
import com.sigfap.admin.model.dao.UnitDAO;
import com.sigfap.admin.model.entity.Address;
import com.sigfap.admin.model.entity.Representative;
import com.sigfap.admin.model.entity.Unit;
import com.sigfap.admin.security.intercept.annotation.Public;

@Controller
public class UnitController {

	private final Result result1;
	@Inject
	private UnitDAO dao;
	
	@Inject
	private AddressDAO dao2;
	
	@Inject
	private InstitutionDAO dao3;
	
	@Inject
	private RepresentativeDAO dao4;
	
	/**
	 * @deprecated CDI eyes only
	 */
	protected UnitController() {
		this(null);
	}
	
	@Inject
	public UnitController(Result result){
		this.result1 = result;
	}
	
/** V1 - Versão 1 **/
	
	@Public
	@Get("/v1/units")
	public void listarUnidade(){
		List<Unit> temp = dao.findAll();
		com.sigfap.admin.json.unit.Result result = 
				new com.sigfap.admin.json.unit.Result();
		result.setUnidades(temp);
		result1.use(Results.json()).from(result).include("unidades")
		.include("unidades.instituicao")
		.include("unidades.enderecoUn")
		.serialize();
	}
	
	@Public
	@Post("/v1/unit")
	public void inserirUnidade(int idRepresentante, Unit unit, Address address){
		String teste = unit.getNome();
		if(teste == null){
			com.sigfap.admin.json.unit.Error error = 
					new com.sigfap.admin.json.unit.Error(
							"Informe um nome");
			result1.use(Results.json()).from(error).recursive().serialize();
			return;
		}
		teste = null;
		teste = unit.getEmail();
		if(teste == null){
			com.sigfap.admin.json.unit.Error error = 
					new com.sigfap.admin.json.unit.Error(
							"Informe um email");
			result1.use(Results.json()).from(error).recursive().serialize();
			return;
		}
		teste = null;
		teste = unit.getCnpj();
		if(teste == null){
			com.sigfap.admin.json.unit.Error error = 
					new com.sigfap.admin.json.unit.Error(
							"Informe um CNPJ");
			result1.use(Results.json()).from(error).recursive().serialize();
			return;
		}
		try{
			dao2.persist(address);
			unit.setEndereco(address);
		}catch(Exception e){
			com.sigfap.admin.json.unit.Error error =
					new com.sigfap.admin.json.unit.Error("Não foi possível salvar endereço");
			result1.use(Results.json()).from(error).recursive().serialize();
			return;
		}
		
		try{
			unit.setInstituicao(dao3.findById(unit.getInstituicao().getId()));
		}catch(Exception e){
			com.sigfap.admin.json.unit.Error error =
					new com.sigfap.admin.json.unit.Error("Id de Instituição não é válido");
			result1.use(Results.json()).from(error).recursive().serialize();
			return;
		}
		
		try{
			Representative temp = dao4.findById(idRepresentante);
			unit.setRepresentante(temp);
		}catch(Exception e){
			com.sigfap.admin.json.unit.Error error = 
					new com.sigfap.admin.json.unit.Error("Representante não encontrado");
			result1.use(Results.json()).from(error).recursive().serialize();
			return;
		}
		
		try{
			dao.persist(unit);
			com.sigfap.admin.json.unit.Result result = 
					new com.sigfap.admin.json.unit.Result();
			result.getUnidades().add(unit);
			result1.use(Results.json()).from(result).include("unidades")
			.include("unidades.instituicao")
			.include("unidades.enderecoUn")
			.serialize();
		}catch(JDBCConnectionException e){
			com.sigfap.admin.json.unit.Error error = 
					new com.sigfap.admin.json.unit.Error(
							"Problema de conexão com o banco, tente mais tarde");
			result1.use(Results.json()).from(error).recursive().serialize();
		}
	}
	
	@Public
	@Put("/v1/unit/{id}")
	public void editarUnidade(int id, Unit unit){
		String teste = unit.getNome();
		if(teste == null){
			com.sigfap.admin.json.unit.Error error = 
					new com.sigfap.admin.json.unit.Error(
							"Informe um nome");
			result1.use(Results.json()).from(error).recursive().serialize();
			return;
		}
		teste = null;
		teste = unit.getEmail();
		if(teste == null){
			com.sigfap.admin.json.unit.Error error = 
					new com.sigfap.admin.json.unit.Error(
							"Informe um email");
			result1.use(Results.json()).from(error).recursive().serialize();
			return;
		}
		teste = null;
		teste = unit.getCnpj();
		if(teste == null){
			com.sigfap.admin.json.unit.Error error = 
					new com.sigfap.admin.json.unit.Error(
							"Informe um CNPJ");
			result1.use(Results.json()).from(error).recursive().serialize();
			return;
		}
		
		try{
			dao.update(unit);
			com.sigfap.admin.json.unit.Result result = 
					new com.sigfap.admin.json.unit.Result();
			result.getUnidades().add(unit);
			result1.use(Results.json()).from(result).include("unidades")
			.include("unidades.instituicao")
			.include("unidades.enderecoUn")
			.serialize();
		}catch(JDBCConnectionException e){
			com.sigfap.admin.json.unit.Error error = 
					new com.sigfap.admin.json.unit.Error(
							"Problema de conexão com o banco, tente mais tarde");
			result1.use(Results.json()).from(error).recursive().serialize();
		}
	}
	
	@Public
	@Delete("/v1/unit/{id}")
	public void removerUnidade(int id){
		try{
			Unit temp = dao.findById(id);
			dao.deleteById(id);
			com.sigfap.admin.json.unit.Result result =
					new com.sigfap.admin.json.unit.Result();
			result.getUnidades().add(temp);
			result1.use(Results.json()).from(result).include("unidades")
			.include("unidades.instituicao")
			.include("unidades.enderecoUn")
			.serialize();
		}catch(JDBCConnectionException e){
			com.sigfap.admin.json.unit.Error error = 
					new com.sigfap.admin.json.unit.Error(
							"Problema de conexão com o banco, tente mais tarde");
			result1.use(Results.json()).from(error).recursive().serialize();
		}catch (Exception e) {
			e.printStackTrace();
			com.sigfap.admin.json.unit.Error error = 
					new com.sigfap.admin.json.unit.Error(
							"Unidade não encontrada");
			result1.use(Results.json()).from(error).recursive().serialize();
		}
	}
	
	
}
