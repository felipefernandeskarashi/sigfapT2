package com.sigfap.admin.controllerRest;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;

@Controller
public class FildResearchController {

	private final Result result;
	
	/**
	 * @deprecated CDI eyes only
	 */
	protected FildResearchController() {
		this(null);
	}
	
	@Inject
	public FildResearchController(Result result){
		this.result = result;
	}
	
/** V1 - Versão 1 **/
	
	@Get("/v1/fildsresearch")
	public void listarArea(){
		
	}
	
	@Post("/v1/fildresearch")
	public void inserirArea(){
		
	}
	
	@Put("/v1/fildresearch")
	public void editarArea(){
		
	}
	
	@Delete("/v1/fildresearch")
	public void removerArea(){
		
	}
	
}
