package com.sigfap.admin.controller;

import java.util.Collection;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

import antlr.collections.List;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
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
		result.redirectTo(IndexController.class).index();
	}
	
	
	@Path("/buscar-instituicao")
	public void buscar(){
		
	}
	
	@Post
	@Path("/exibir-instituicoes")
	public void exibir(Institution institution, Integer tipoOrdenacao, Integer situacao, Integer limitePorPagina){
		result.include("busca", dao.findByExample(institution));
	}
	
	@Get
	@Path("/institution/edit/{id}")
	public void edit (int id)
	{
		result.include("edit", dao.findById(id));
	}
	
	@Get
	@Path("/institution/delete/{id}")
	public void delete (int id)
	{
		dao.delete(dao.findById(id));
		result.redirectTo(this).buscar();
	}
	
	@Post
	@Get
	@Path("/institution/edit")
	public void editInst(Institution edit, int idInst){
		edit.setId(idInst);
		
		try{
			edit.setAtiva(true);
			dao.update(edit);
			
		}catch(Exception e){
			System.out.println("Erro Edição"+e.getMessage());
		}
		result.redirectTo(IndexController.class).index();
	}
}