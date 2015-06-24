package com.sigfap.admin.controllerRest;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

import com.sigfap.admin.model.dao.ResearchDAO;
import com.sigfap.admin.model.entity.Research;
import com.sigfap.admin.security.intercept.annotation.Public;

@Controller
public class ResearchController {

	private final Result result;
	
	private ResearchDAO dao;
	
	/**
	 * @deprecated CDI eyes only
	 */
	protected ResearchController() {
		this(null, null);
	}
	
	@Inject
	public ResearchController(Result result, ResearchDAO dao){
		this.result = result;
		this.dao = dao;
	}
	
	/** V1 - Versão 1 **/
	
	@Public
	@Get
	@Path("/v1/researches")
	public void listarPesquisador(){
		
		List<Research> researches = dao.findAll();
		
		com.sigfap.admin.json.research.Result result1 = new com.sigfap.admin.json.research.Result();
		result1.setValue(researches);
		
		result.use(Results.json()).from(result).include("value").exclude("value.pesquisadorUnidades").serialize();
	}
	
	@Public
	@Post
	@Path("/v1/researcher")
	public void inserirPesquisador(Research research){
		//faze de teste
		try {
			
			dao.persist(research);			
			com.sigfap.admin.json.research.Result result1 = new com.sigfap.admin.json.research.Result();
			result1.getValue().add(research);
			result.use(Results.json()).from(result1).exclude("value.pesquisadorUnidades").serialize();
			
		} catch (Exception e) {
			
			com.sigfap.admin.json.research.Error error = new com.sigfap.admin.json.research.Error("Impossivel criar Pesquisador");
			result.use(Results.json()).from(error).serialize(); 			
		}
	}
	
	@Public
	@Put("/v1/researcher")
	public void editarPesquisador(){
		
	}
	
	@Public
	@Delete("/v1/researcher/{id}")
	public void removerPesquisador(int id){
//		Research research = dao.findById(id);
//		try {
//			dao.deleteById(id);
//			com.sigfap.admin.json.research.Result result = new com.sigfap.admin.json.research.Result();
//			result.getPesquisadores().add(research);
//			
//			result1.use(Results.json()).from(result).recursive().serialize();
//			result1.include(result);
//		} catch (Exception e) {
//			com.sigfap.admin.json.research.Error error = new com.sigfap.admin.json.research.Error("Pesquisador não encontrado.");
//			result1.use(Results.json()).from(error).serialize();
//			result1.include(error);
//		}
	}
	
	
}
