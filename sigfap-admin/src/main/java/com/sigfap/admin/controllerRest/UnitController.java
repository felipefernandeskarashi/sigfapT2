package com.sigfap.admin.controllerRest;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.exception.JDBCConnectionException;

import com.sigfap.admin.json.unit.Error;
import com.sigfap.admin.model.dao.UnitDAO;
import com.sigfap.admin.model.entity.Unit;
import com.sigfap.admin.security.intercept.annotation.Public;
import com.sun.jndi.url.corbaname.corbanameURLContextFactory;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Controller
public class UnitController {

	private final Result result1;
	@Inject
	private UnitDAO dao;
	
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
	public void inserirUnidade(Unit unit){
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
		}catch (Exception e) {
			e.printStackTrace();
			com.sigfap.admin.json.unit.Error error = 
					new com.sigfap.admin.json.unit.Error(
							"Unidade não encontrada");
		}
	}
	
	
}
