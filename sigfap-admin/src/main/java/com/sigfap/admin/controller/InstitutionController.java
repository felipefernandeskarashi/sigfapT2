package com.sigfap.admin.controller;

import java.util.Collection;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

import antlr.collections.List;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

import com.sigfap.admin.model.dao.InstitutionDAO;
import com.sigfap.admin.model.entity.Institution;

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
			institution.setAtiva(true);
			dao.persist(institution);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		result.redirectTo(this).index();
	}
	
	
	@Path("/buscar-instituicao")
	public void buscar(){
		
	}
	
	@Post
	@Path("/exibir-instituicoes")
	public void exibir(Institution institution, Integer tipoOrdenacao, Integer situacao, Integer limitePorPagina){
		result.include("busca", dao.findByExample(institution));
	}
}