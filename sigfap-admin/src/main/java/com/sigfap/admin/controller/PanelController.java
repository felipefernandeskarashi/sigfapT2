package com.sigfap.admin.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Severity;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;

import com.sigfap.admin.model.dao.ResearchDAO;
import com.sigfap.admin.model.entity.Research;
import com.sigfap.admin.security.intercept.annotation.Public;

@Controller
public class PanelController {
	private final Result result;
	private Validator validator;


	/**
	 * @deprecated CDI eyes only
	 */
	protected PanelController() {
		this(null, null);
		
	}
	
	@Inject
	public PanelController(Result result, Validator validator) {
		this.result = result;
		this.validator = validator;
	}
	
	@Inject
	private ResearchDAO dao;

	
	@Path("/panel")
	public void index() {
		
	}
	
	
	@Get
	@Path("/editResearch/")
	public void edit (int id)
	{
		result.include("edit", dao.findById(id));
	}
	
	
//	@Post
//	@Get
//	@Path("/editResearch")
//	public void editRe(Research edit){
//		try{
//			
//			dao.update(edit);
//		}catch(Exception e){
//			System.out.println("Erro Edição"+e.getMessage());
//			validator.add(new SimpleMessage("error", "", Severity.ERROR));
//		}
		//result.redirectTo(this).buscar();
		
//	}
	
}
