package com.sigfap.admin.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;

import com.sigfap.admin.model.dao.ResearchDAO;
import com.sigfap.admin.model.entity.Research;
import com.sigfap.admin.security.intercept.annotation.Public;

@Controller
public class IndexController {

	private final Result result;

	@Inject
	private ResearchDAO dao;

	/**
	 * @deprecated CDI eyes only
	 */
	protected IndexController() {
		this(null);
	}

	@Inject
	public IndexController(Result result) {
		this.result = result;
	}

	@Path("/")
	public void index() {

	}

	@Path("/findResearch")
	public void findResearch() {

	}

	@Post
	@Path("/displayResearch")
	public void displayResearch(Research research) {
		try {
			dao.findByExample(research);
			result.include("busca", dao.findByExample(research));
			result.redirectTo(IndexController.class).index();
		} catch (Exception e) {
			result.redirectTo(this).index();
		}
		
	}

	@Path("/removeResearch")
	public void removeResearch() {

	}

	@Get
	@Delete
	@Path("/remove/{id}")
	public void remove(int id) {
		try {
			Research delete = dao.findById(id);
			delete.setAtivo(false);
			dao.update(delete);
			result.redirectTo(IndexController.class).index();
		} catch (Exception e) {
			result.redirectTo(this).index();
		}
	}
	
//	Institution delete = dao.findById(id);
//	delete.setAtiva(false);
//	dao.update(delete);
//	result.redirectTo(this).buscar();
	
	
	@Path("/listResearch")
	public void listResearch() {
		List<Research> listaPesquisadores = dao.findAll();
		result.include("busca", listaPesquisadores);
	}
	
	@Path("/editResearchAdm")
	public void editResearchAdm() {

	}

	@Post
	@Path("/editAdm")
	public void editAdm(Research research) {
		try {
			dao.update(research);
			result.redirectTo(IndexController.class).index();
		} catch (Exception e) {
			result.redirectTo(this).index();
		}
	}

}