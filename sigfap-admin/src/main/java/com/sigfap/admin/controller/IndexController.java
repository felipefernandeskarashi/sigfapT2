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

	@Path("/find/research")
	public void findResearch() {

	}

	@Post
	@Path("/display/research")
	public void displayResearch(Research research) {
		try {
			dao.findByExample(research);
			result.include("busca", dao.findByExample(research));
		} catch (Exception e) {
			result.redirectTo(this).index();
		}

	}

	@Path("/remove/research/find")
	public void removeResearch() {

	}

	@Get
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

	// Tem que ver o path correto
	@Post
	@Path("/remove/research/display")
	public void removeDisplayResearch(Research research) {
		try {
			List<Research> pesquisadores = dao.findByExample(research);
			result.include("busca", pesquisadores);
		} catch (Exception e) {
			result.redirectTo(this).index();
		}
	}

	@Path("/list/researchers")
	public void listResearch() {
		List<Research> listaPesquisadores = dao.findAll();
		result.include("busca", listaPesquisadores);
	}

	@Path("/edit/research/find")
	public void editResearchAdm() {

	}

	@Post
	@Path("/edit/research/display")
	public void displayEditResearch(Research research) {
		try {
			List<Research> pesquisadores = dao.findByExample(research);
			result.include("busca", pesquisadores);
		} catch (Exception e) {
			result.redirectTo(this).index();
		}
	}

}