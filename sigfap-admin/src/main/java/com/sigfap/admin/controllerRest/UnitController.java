package com.sigfap.admin.controllerRest;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;

@Controller
public class UnitController {

	private final Result result;
	
	/**
	 * @deprecated CDI eyes only
	 */
	protected UnitController() {
		this(null);
	}
	
	@Inject
	public UnitController(Result result){
		this.result = result;
	}
	
/** V1 - Versão 1 **/
	
	@Get("/v1/units")
	public void listarUnidade(){
		
	}
	
	@Post("/v1/unit")
	public void inserirUnidade(){
		
	}
	
	@Put("/v1/unit")
	public void editarUnidade(){
		
	}
	
	@Delete("/v1/unit")
	public void removerUnidade(){
		
	}
	
	
}
