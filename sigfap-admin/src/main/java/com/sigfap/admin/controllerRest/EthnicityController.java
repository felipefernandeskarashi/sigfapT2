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
public class EthnicityController {

	private final Result result;
	
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
	
	@Get
	@Path("/v1/ethnicities")
	public void listarEtnia(){
		
	}
	
	@Post
	@Path("/v1/ethnicity")
	public void inserirEtnia(){
		
	}
	
	@Put
	@Path("/v1/ethnicity")
	public void editarEtnia(){
		
	}
	
	@Delete
	@Path("/v1/ethnicity")
	public void removerEtnia(){
		
	}
	
	
}
