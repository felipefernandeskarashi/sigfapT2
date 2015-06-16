package com.sigfap.admin.controllerRest;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;




@Controller
public class InstitutionController {

	private final Result result;
	
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
	
	@Get("/v1/institutions")
	public void listarInstituicao(){
		
	}
	
	@Post("/v1/institution")
	public void inserirInstituicao(){
		
	}
	
	@Put("/v1/institution")
	public void editarInstituicao(){
		
	}
	
	@Delete("/v1/institution")
	public void removerInstituicao(){
		
	}
	
	
	
}
