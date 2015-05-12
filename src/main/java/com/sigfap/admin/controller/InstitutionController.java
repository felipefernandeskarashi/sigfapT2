package com.sigfap.admin.controller;

import javax.inject.Inject;

import com.sigfap.admin.model.dao.InstitutionDAO;
import com.sigfap.admin.model.entity.Institution;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class InstitutionController{
	private final Result result;
	
	private Validator validator;
	@Inject
	private InstitutionDAO dao;
	
	/**
	 * @deprecated CDI eyes only
	 */
	protected InstitutionController(){
		this(null);
	}
	
	@Inject
	public InstitutionController(Result result){
		this.result = result;
	}
	
	
	@Path("/registrar-instituicao")
	public void index(){
		
	}
	
	@Post
	@Path("/registrar-instituicao1")
	public void registrar(Institution institution){
		try{
			institution.setNome(institution.getNome());
			institution.setSigla(institution.getSigla());
			institution.setDependenciaAdm(institution.getDependenciaAdm());
			institution.setIes(institution.getIes());
			institution.setFinsLucrativos(institution.getFinsLucrativos());
			institution.setAtiva(true);
			dao.persist(institution);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		result.redirectTo(this).index();
	}
}