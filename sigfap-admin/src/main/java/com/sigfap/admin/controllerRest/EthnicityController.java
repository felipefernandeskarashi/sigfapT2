package com.sigfap.admin.controllerRest;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.exception.JDBCConnectionException;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

import com.sigfap.admin.model.dao.EthnicityDAO;
import com.sigfap.admin.model.entity.Ethnicity;
import com.sigfap.admin.security.intercept.annotation.Public;



@Controller
public class EthnicityController {

	private final Result result;
	
	@Inject
	private EthnicityDAO dao;
	
	/**
	 * @deprecated CDI eyes only
	 */
	protected EthnicityController(){
		this(null);
	}

	@Inject	
	public EthnicityController(Result result) {
		this.result = result;
	}
	
	
	/** V1 - Versão 1 **/
	
	@Public
	@Get
	@Path("/v1/ethnicities")
	public void listarEtnia(){
				
			List<Ethnicity> lista = dao.findAll();
			
			if(!lista.isEmpty()){
				com.sigfap.admin.json.ethnicity.Result result1 = new com.sigfap.admin.json.ethnicity.Result();
				result1.setValue(lista);
				result.use(Results.json()).from(result1).exclude("value.pesquisadores").recursive().serialize();
			}
			else{
				com.sigfap.admin.json.ethnicity.Error error = new com.sigfap.admin.json.ethnicity.Error("Lista não encontrada");
				result.use(Results.json()).from(error).recursive().serialize();
			}

	}
	
	@Public
	@Post
	@Path("/v1/ethnicity")
	public void inserirEtnia(Ethnicity ethnicity){
		
		try {
		
			if(ethnicity.getNome() == null){
				com.sigfap.admin.json.ethnicity.Error error = new com.sigfap.admin.json.ethnicity.Error("O campo nome deve ser preenchido");
				result.use(Results.json()).from(error).serialize(); 
				return;			
			}	
			
			dao.persist(ethnicity);			
			com.sigfap.admin.json.ethnicity.Result result1 = new com.sigfap.admin.json.ethnicity.Result();
			result1.getValue().add(ethnicity);
			result.use(Results.json()).from(result1).exclude("value.pesquisadores").recursive().serialize();
			
		} catch(JDBCConnectionException e){
			
			com.sigfap.admin.json.ethnicity.Error error = new com.sigfap.admin.json.ethnicity.Error("Problema de conexão com o banco");
			result.use(Results.json()).from(error).recursive().serialize();
			
		} catch (Exception e) {
			
			com.sigfap.admin.json.ethnicity.Error error = new com.sigfap.admin.json.ethnicity.Error("Impossivel criar Etnia");
			result.use(Results.json()).from(error).serialize(); 			
		}
	}
	
	@Public
	@Put
	@Path("/v1/ethnicity/{id}")
	public void editarEtnia(Ethnicity ethnicity){
		
		try {
			
			if(ethnicity.getNome() == null){
				com.sigfap.admin.json.ethnicity.Error error = new com.sigfap.admin.json.ethnicity.Error("O campo nome deve ser preenchido");
				result.use(Results.json()).from(error).serialize(); 
				return;			
			}
			
			dao.update(ethnicity);
			com.sigfap.admin.json.ethnicity.Result result1 = new com.sigfap.admin.json.ethnicity.Result();
			result1.getValue().add(ethnicity);
			result.use(Results.json()).from(result1).exclude("value.pesquisadores").recursive().serialize();
			
		} catch(JDBCConnectionException e){
			
			com.sigfap.admin.json.ethnicity.Error error = new com.sigfap.admin.json.ethnicity.Error("Problema de conexão com o banco");
			result.use(Results.json()).from(error).recursive().serialize();
			
		} catch (Exception e) {
			
			com.sigfap.admin.json.ethnicity.Error error = new com.sigfap.admin.json.ethnicity.Error("Impossivel editar Etnia");
			result.use(Results.json()).from(error).serialize(); 
		}
		
		
	}
	
	@Public
	@Delete
	@Path("/v1/ethnicity/{id}")
	public void removerEtnia(Ethnicity ethnicity){
	
		
		try {
			
			dao.delete(ethnicity);			
			com.sigfap.admin.json.ethnicity.Result result1 = new com.sigfap.admin.json.ethnicity.Result();
			result1.getValue().add(ethnicity);
			result.use(Results.json()).from(result1).exclude("value.pesquisadores").recursive().serialize();
			
		} catch(JDBCConnectionException e){
			
			com.sigfap.admin.json.ethnicity.Error error = new com.sigfap.admin.json.ethnicity.Error("Problema de conexão com o banco");
			result.use(Results.json()).from(error).recursive().serialize();
			
		} catch (Exception e) {
			
			com.sigfap.admin.json.ethnicity.Error error = new com.sigfap.admin.json.ethnicity.Error("Impossivel remover Etnia");
			result.use(Results.json()).from(error).serialize(); 
		}
	}
	
	
}
