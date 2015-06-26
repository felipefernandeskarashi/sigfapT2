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

import com.sigfap.admin.model.dao.InstitutionDAO;
import com.sigfap.admin.model.entity.Institution;
import com.sigfap.admin.security.intercept.annotation.Public;




@Controller
public class InstitutionController {

	private final Result result;
	
	@Inject
	private InstitutionDAO dao;
	
	/**
	 * @deprecated CDI eyes only
	 */
	protected InstitutionController() {
		this(null);
	}
	
	@Inject
	public InstitutionController(Result result){
		this.result = result;
	}
	
	
	/** V1 - Versão 1 **/
	
	@Public
	@Get
	@Path("/v1/institutions")
	public void listarInstituicao(){
		
		List<Institution> lista = dao.findAll();
		
		if(!lista.isEmpty()){
			com.sigfap.admin.json.institution.Result result1 = new com.sigfap.admin.json.institution.Result();
			result1.setValue(lista);
			result.use(Results.json()).from(result1).exclude("value.unidades").recursive().serialize();
		}
		else{
			com.sigfap.admin.json.institution.Error error = new com.sigfap.admin.json.institution.Error("Lista não encontrada");
			result.use(Results.json()).from(error).recursive().serialize();
		}
	}
	
	@Public
	@Post
	@Path("/v1/institution")
	public void inserirInstituicao(Institution institution){
		
		try {
			
			if(institution.getNome() == null){
				com.sigfap.admin.json.institution.Error error = new com.sigfap.admin.json.institution.Error("O campo nome deve ser preenchido");
				result.use(Results.json()).from(error).serialize(); 
				return;			
			}
			
			if(institution.getSigla() == null){
				com.sigfap.admin.json.institution.Error error = new com.sigfap.admin.json.institution.Error("O campo sigla deve ser preenchido");
				result.use(Results.json()).from(error).serialize(); 
				return;			
			}	
			
			if(institution.getDependenciaAdm() < 1 || institution.getDependenciaAdm() > 6){
				com.sigfap.admin.json.institution.Error error = new com.sigfap.admin.json.institution.Error("O campo dependencia administrativa deve estar entre 1 e 6");
				result.use(Results.json()).from(error).serialize(); 
				return;
			}
			
			dao.persist(institution);			
			com.sigfap.admin.json.institution.Result result1 = new com.sigfap.admin.json.institution.Result();
			result1.getValue().add(institution);
			result.use(Results.json()).from(result1).exclude("value.unidades").recursive().serialize();
			
		}catch(JDBCConnectionException e){
			
			com.sigfap.admin.json.institution.Error error = new com.sigfap.admin.json.institution.Error("Problema de conexão com o banco");
			result.use(Results.json()).from(error).recursive().serialize();
			
		} catch (Exception e) {
			
			com.sigfap.admin.json.institution.Error error = new com.sigfap.admin.json.institution.Error("Impossivel criar instituiçao");
			result.use(Results.json()).from(error).serialize(); 			
		}
	}
	
	@Public
	@Put
	@Path("/v1/institution/{id}")
	public void editarInstituicao(Institution institution){
		
		try {
			
			if(institution.getNome() == null){
				com.sigfap.admin.json.institution.Error error = new com.sigfap.admin.json.institution.Error("O campo nome deve ser preenchido");
				result.use(Results.json()).from(error).serialize(); 
				return;			
			}
			
			if(institution.getSigla() == null){
				com.sigfap.admin.json.institution.Error error = new com.sigfap.admin.json.institution.Error("O campo sigla deve ser preenchido");
				result.use(Results.json()).from(error).serialize(); 
				return;			
			}	
			
			if(institution.getDependenciaAdm() < 1 || institution.getDependenciaAdm() > 6){
				com.sigfap.admin.json.institution.Error error = new com.sigfap.admin.json.institution.Error("O campo dependencia administrativa deve estar entre 1 e 6");
				result.use(Results.json()).from(error).serialize(); 
				return;
			}
			
			dao.update(institution);
			com.sigfap.admin.json.institution.Result result1 = new com.sigfap.admin.json.institution.Result();
			result1.getValue().add(institution);
			result.use(Results.json()).from(result1).exclude("value.unidades").recursive().serialize();
			
		} catch(JDBCConnectionException e){
			
			com.sigfap.admin.json.institution.Error error = new com.sigfap.admin.json.institution.Error("Problema de conexão com o banco");
			result.use(Results.json()).from(error).recursive().serialize();
			
		} catch (Exception e) {
			
			com.sigfap.admin.json.institution.Error error = new com.sigfap.admin.json.institution.Error("Impossivel editar Instituição");
			result.use(Results.json()).from(error).serialize(); 
		}
	}
	
	@Public
	@Delete
	@Path("/v1/institution/{id}")
	public void removerInstituicao(Institution institution){
		
		try {
			
			dao.delete(institution);			
			com.sigfap.admin.json.institution.Result result1 = new com.sigfap.admin.json.institution.Result();
			result1.getValue().add(institution);
			result.use(Results.json()).from(result1).exclude("value.unidades").recursive().serialize();
			
		} catch (Exception e) {
			
			com.sigfap.admin.json.institution.Error error = new com.sigfap.admin.json.institution.Error("Impossivel remover Instituição");
			result.use(Results.json()).from(error).serialize(); 
		}
	}
	
	
	
}
