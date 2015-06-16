package com.sigfap.admin.controllerRest;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;

@Controller
public class ResearchController {

	private final Result result;
	
	/**
	 * @deprecated CDI eyes only
	 */
	protected ResearchController() {
		this(null);
	}
	
	@Inject
	public ResearchController(Result result){
		this.result = result;
	}
	
	/** V1 - Versão 1 **/
	
	@Get("/v1/researches")
	public void listarPesquisador(){
		
	}
	
	@Post("/v1/researcher")
	public void inserirPesquisador(){
		
	}
	
	@Put("/v1/researcher")
	public void editarPesquisador(){
		
	}
	
	@Delete("/v1/researcher")
	public void removerPesquisador(){
		
	}
	
	
}
